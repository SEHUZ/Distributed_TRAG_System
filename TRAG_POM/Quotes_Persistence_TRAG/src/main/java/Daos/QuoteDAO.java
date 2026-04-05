/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Connection.Connection;
import Entitys.Quote;
import Entitys.QuoteSupply;
import Enums.QuoteStatus;
import Exception.PersistenceException;
import Interfaces.IQuotesDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author sonic
 */
public class QuoteDAO implements IQuotesDAO {

    private final String ERROR_ADD = "Error adding the quote.";
    private final String ERROR_FIND = "Error finding the quote.";
    private final String ERROR_FIND_ALL = "Error finding all quotes.";
    private final String ERROR_FIND_CUSTOMER = "Error finding quotes by customer IDs.";
    private final String ERROR_FIND_DATES = "Error finding quotes by date range.";
    private final String ERROR_UPDATE = "Error updating the quote.";
    private final String ERROR_CANCEL = "Error canceling the quote.";

    @Override
    public Quote addQuote(Quote quote) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            EntityTransaction transaccion = em.getTransaction();
            transaccion.begin();

            // Nota Arquitectónica: Ya no usamos em.getReference() para Servicios o Insumos
            // porque ahora son solo campos numéricos (serviceId, supplyId) en la entidad Quote.

            if (quote.getQuoteSupplies() != null && !quote.getQuoteSupplies().isEmpty()) {
                for (QuoteSupply quoteSupply : quote.getQuoteSupplies()) {
                    // Solo aseguramos la relación bidireccional local
                    quoteSupply.setQuote(quote);
                    if (quoteSupply.getActive() == null) {
                        quoteSupply.setActive(true);
                    }
                }
            }

            em.persist(quote);

            transaccion.commit();
            return quote;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException(ERROR_ADD, e);
        } finally {
            em.close();
        }
    }

    @Override
    public Quote getQuote(Long idQuote) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String jpql = "SELECT DISTINCT q FROM Quote q " +
                          "LEFT JOIN FETCH q.quoteSupplies qs " +
                          "WHERE q.id = :id";

            return em.createQuery(jpql, Quote.class)
                     .setParameter("id", idQuote)
                     .setHint(QueryHints.REFRESH, HintValues.TRUE)
                     .getSingleResult();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Quote> getAllQuotes() throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String jpql = "SELECT DISTINCT q FROM Quote q " +
                          "LEFT JOIN FETCH q.quoteSupplies qs";

            return em.createQuery(jpql, Quote.class)
                     .setHint(QueryHints.REFRESH, HintValues.TRUE)
                     .getResultList();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND_ALL, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Quote> getQuotesByCustomerIds(List<Long> customerIds) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            if (customerIds == null || customerIds.isEmpty()) {
                return new ArrayList<>();
            }

            String jpql = "SELECT DISTINCT q FROM Quote q " +
                          "LEFT JOIN FETCH q.quoteSupplies qs " +
                          "WHERE q.customerId IN :ids";

            return em.createQuery(jpql, Quote.class)
                     .setParameter("ids", customerIds)
                     .setHint(QueryHints.REFRESH, HintValues.TRUE)
                     .getResultList();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND_CUSTOMER, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Quote> getQuotesByDate(LocalDateTime startDate, LocalDateTime endDate) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String jpql = "SELECT DISTINCT q FROM Quote q " +
                          "LEFT JOIN FETCH q.quoteSupplies qs " +
                          "WHERE q.createdAt BETWEEN :startDate AND :endDate";

            return em.createQuery(jpql, Quote.class)
                     .setParameter("startDate", startDate)
                     .setParameter("endDate", endDate)
                     .setHint(QueryHints.REFRESH, HintValues.TRUE)
                     .getResultList();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND_DATES, e);
        } finally {
            em.close();
        }
    }

    @Override
    public Quote updateQuote(Quote quote) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            em.getTransaction().begin();

            Quote existingQuote = em.find(Quote.class, quote.getId());

            if (existingQuote != null) {
                if (quote.getLaborPrice() != null) existingQuote.setLaborPrice(quote.getLaborPrice());
                if (quote.getVehicleStatus() != null) existingQuote.setVehicleStatus(quote.getVehicleStatus());
                if (quote.getGeneralDiagnosis() != null) existingQuote.setGeneralDiagnosis(quote.getGeneralDiagnosis());
                if (quote.getCreatedAt() != null) existingQuote.setCreatedAt(quote.getCreatedAt());

                if (quote.getQuoteSupplies() != null) {
                    
                    Map<Long, QuoteSupply> existingMap = new HashMap<>();
                    for (QuoteSupply existing : existingQuote.getQuoteSupplies()) {
                        existingMap.put(existing.getSupplyId(), existing);
                    }

                    List<QuoteSupply> newSupplies = new ArrayList<>();
                    List<Long> incomingIds = new ArrayList<>();

                    for (QuoteSupply incoming : quote.getQuoteSupplies()) {
                        Long idSupply = incoming.getSupplyId();
                        incomingIds.add(idSupply);

                        QuoteSupply existing = existingMap.get(idSupply);

                        if (existing != null) {
                            existing.setActive(true);
                            existing.setQuantityRequired(incoming.getQuantityRequired());
                            existing.setPrice(incoming.getPrice());
                        } else {
                            incoming.setQuote(existingQuote);
                            incoming.setActive(true);
                            newSupplies.add(incoming);
                        }
                    }

                    for (QuoteSupply existing : existingQuote.getQuoteSupplies()) {
                        if (!incomingIds.contains(existing.getSupplyId())) {
                            existing.setActive(false);
                        }
                    }

                    if (!newSupplies.isEmpty()) {
                        existingQuote.getQuoteSupplies().addAll(newSupplies);
                    }
                }
            }

            em.getTransaction().commit();
            return existingQuote;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException(ERROR_UPDATE, e);
        } finally {
            em.close();
        }
    }

    @Override
    public Quote deleteQuote(Long idQuote) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            em.getTransaction().begin();
            Quote quote = em.find(Quote.class, idQuote);

            if (quote != null) {
                quote.setStatus(QuoteStatus.CANCELLED); 
                
                if (quote.getQuoteSupplies() != null) {
                    for (QuoteSupply supply : quote.getQuoteSupplies()) {
                        supply.setActive(false);
                    }
                }
            }

            em.getTransaction().commit();
            return quote;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException(ERROR_CANCEL, e);
        } finally {
            em.close();
        }
    }

    @Override
    public Quote enableQuote(Long idQuote) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            em.getTransaction().begin();
            Quote quote = em.find(Quote.class, idQuote);

            if (quote != null) {
                quote.setStatus(QuoteStatus.ENABLED);
                
                if (quote.getQuoteSupplies() != null) {
                    for (QuoteSupply supply : quote.getQuoteSupplies()) {
                        supply.setActive(true);
                    }
                }
            }

            em.getTransaction().commit();
            return quote;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException("Error enabling the quote.", e);
        } finally {
            em.close();
        }
    }
}
