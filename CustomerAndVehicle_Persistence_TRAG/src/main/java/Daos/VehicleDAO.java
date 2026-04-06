/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Connection.Connection;
import Entitys.Customer;
import Entitys.Vehicle;
import Exception.PersistenceException;
import Interfaces.IVehicleDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author sonic
 */
public class VehicleDAO implements IVehicleDAO{

    private final String ERROR_ADD = "Error adding the vehicle.";
    private final String ERROR_FIND = "Error finding the vehicle.";
    private final String ERROR_FIND_ALL = "Error finding all vehicles.";
    private final String ERROR_UPDATE = "Error updating the vehicle.";

    @Override
    public Vehicle addVehicle(Vehicle vehicle) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            EntityTransaction transaccion = em.getTransaction();
            transaccion.begin();

            if (vehicle.getCustomer() != null && vehicle.getCustomer().getId() != null) {
                Customer customerRef = em.getReference(Customer.class, vehicle.getCustomer().getId());
                vehicle.setCustomer(customerRef);
            }

            if (vehicle.getActive() == null) {
                vehicle.setActive(true);
            }

            em.persist(vehicle);

            transaccion.commit();
            return vehicle;

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
    public Vehicle getVehicle(Long idVehicle) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String jpql = "SELECT v FROM Vehicle v "
                    + "JOIN FETCH v.customer "
                    + "WHERE v.id = :id AND v.active = :active";

            return em.createQuery(jpql, Vehicle.class)
                    .setParameter("id", idVehicle)
                    .setParameter("active", true)
                    .getSingleResult();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String jpql = "SELECT v FROM Vehicle v "
                    + "JOIN FETCH v.customer "
                    + "WHERE v.active = :active";

            return em.createQuery(jpql, Vehicle.class)
                    .setParameter("active", true)
                    .getResultList();

        } catch (Exception e) {
            throw new PersistenceException(ERROR_FIND_ALL, e);
        } finally {
            em.close();
        }
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Vehicle updatedVehicle = em.merge(vehicle);

            transaction.commit();
            return updatedVehicle;

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
