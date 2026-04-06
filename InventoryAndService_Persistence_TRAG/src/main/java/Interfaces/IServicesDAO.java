/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entitys.Service;
import Exception.PersistenceException;
import java.util.List;

/**
 *
 * @author sonic
 */
public interface IServicesDAO {
    public abstract Service addService(Service servicio) throws PersistenceException;
    public abstract Service getService(Long idServicio) throws PersistenceException;
    public abstract List<Service> getAllServices() throws PersistenceException;
    public abstract List<Service> getServicesNames(String serviceName) throws PersistenceException;
}
