/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Connection.Connection;
import Entitys.Supply;
import Exception.PersistenceException;
import Interfaces.ISuppliesDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author sonic
 */
public class SuppliesDAO implements ISuppliesDAO{

 
    private final String ADD_ERROR_MESSAGE = "ERROR while adding the supply.";
    private final String SEARCH_ERROR_MESSAGE = "ERROR while searching supply.";
    
    @Override
    public Supply addSupply(Supply supply) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(supply);
            em.getTransaction().commit();
            return supply;
            
        } catch (Exception e) {
            
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException(ADD_ERROR_MESSAGE, e);
        } finally {
            em.close();
        }
    }

    @Override
    public Supply getSupply(Long supplyId) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            return em.find(Supply.class, supplyId);
        } catch (Exception e) {
            throw new PersistenceException(SEARCH_ERROR_MESSAGE, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Supply> getSuppliesName(String supplyName) throws PersistenceException {
        EntityManager em = Connection.crearConexion();
        try {
            String terminoBusqueda = "%" + supplyName.trim().toLowerCase() + "%";

            String jpql = "SELECT i FROM Insumo i WHERE LOWER(i.nombre) LIKE :nombre";

            return em.createQuery(jpql, Supply.class)
                     .setParameter("nombre", terminoBusqueda)
                     .getResultList();

        } catch (Exception e) {
            throw new PersistenceException(SEARCH_ERROR_MESSAGE, e);
        } finally {
            em.close();
        }
    }
}
