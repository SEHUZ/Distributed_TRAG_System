/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Enums.CustomerStatus;
import javax.persistence.EntityTransaction;
import Connection.Connection;
import Entitys.Customer;
import Exception.PersistenceException;
import Interfaces.ICustomerDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author sonic
 */
public class CustomerDAO implements ICustomerDAO {
    
    private final String ERROR_ADD = "Error adding the customer.";
    private final String ERROR_FIND = "Error finding the customer.";
    private final String ERROR_FIND_ALL = "Error finding all customers.";
    private final String ERROR_UPDATE = "Error updating the customer.";

    @Override
    public Customer createCustomer(Customer customer) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Aseguramos que el cliente nazca con un estado activo por defecto si no lo trae
            if (customer.getStatus() == null) {
                customer.setStatus(CustomerStatus.ENABLED); 
            }

            em.persist(customer);

            transaction.commit();
            return customer;
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
    public Customer getCustomer(Long customerId) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String jpql = "SELECT c FROM Customer c "
                        + "LEFT JOIN FETCH c.vehicles "
                        + "WHERE c.id = :id AND c.status = :status";
                        
            return em.createQuery(jpql, Customer.class)
                     .setParameter("id", customerId)
                     .setParameter("status", CustomerStatus.ENABLED)
                     .getSingleResult();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenceException("Error fetching all customers: " + e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            em.getTransaction().begin();
            Customer updatedCustomer = em.merge(customer);
            em.getTransaction().commit();
            return updatedCustomer;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException(ERROR_UPDATE, e);
        } finally {
            em.close();
        }
    }
    
    
}
