/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Connection.Connection;
import Entitys.Service;
import Entitys.ServiceSupply;
import Entitys.Supply;
import Exception.PersistenceException;
import Interfaces.IServicesDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author sonic
 */
public class ServicesDAO implements IServicesDAO {

    private final String ERROR_ADD = "Error adding the service.";
    private final String ERROR_FIND = "Error finding the service.";
    private final String ERROR_FIND_ALL = "Error finding all services.";
    private final String ERROR_UPDATE = "Error updating the service.";
    private final String ERROR_DELETE = "Error deleting the service.";
    
    @Override
    public Service addService(Service service) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            em.getTransaction().begin();

            if (service.getServiceSupplies() != null && !service.getServiceSupplies().isEmpty()) {

                for (ServiceSupply serviceSupply: service.getServiceSupplies()) {
                    serviceSupply.setService(service);

                    if (serviceSupply.getSupply() != null && serviceSupply.getSupply().getId() != null) {
                        Supply supplyReference = em.getReference(Supply.class, serviceSupply.getSupply().getId());
                        serviceSupply.setSupply(supplyReference);
                    }
                }
            }

            em.persist(service);

            em.getTransaction().commit();
            return service;

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
    public Service getService(Long idService) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            
            String jpql = "SELECT DISTINCT s FROM Service s " +
                          "LEFT JOIN FETCH s.serviceSupplies i " +
                          "WHERE s.id = :id AND s.active = :active " +
                          "AND (i.id IS NULL OR i.active = :activeSupply)";

            return em.createQuery(jpql, Service.class)
                     .setParameter("id", idService)
                     .setParameter("active", true)
                     .setParameter("activeSupply", true)
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
    public List<Service> getAllServices() throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String jpql = "SELECT DISTINCT s FROM Service s " +
                          "LEFT JOIN FETCH s.serviceSupplies i " +
                          "WHERE s.active = :active " +
                          "AND (i.id IS NULL OR i.active = :activeSupply)";

            return em.createQuery(jpql, Service.class)
                     .setParameter("active", true)
                     .setParameter("activeSupply", true)
                     .getResultList();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND_ALL, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Service> getServicesNames(String serviceName) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String searchTerm = "%" + serviceName.trim().toLowerCase() + "%";

            String jpql = "SELECT DISTINCT s FROM Service s " +
                          "LEFT JOIN FETCH s.serviceSupplies i " +
                          "WHERE s.active = :active " +
                          "AND (i.id IS NULL OR i.active = :activeSupply) " +
                          "AND LOWER(s.name) LIKE :name";

            return em.createQuery(jpql, Service.class)
                     .setParameter("active", true)
                     .setParameter("activeSupply", true)
                     .setParameter("name", searchTerm)
                     .setHint(QueryHints.REFRESH, HintValues.TRUE) 
                     .getResultList();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND_ALL, e);
        } finally {
            em.close();
        }
    }

}
