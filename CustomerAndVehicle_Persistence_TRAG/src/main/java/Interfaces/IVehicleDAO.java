/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entitys.Vehicle;
import Exceptions.PersistenceException;
import java.util.List;

/**
 *
 * @author sonic
 */
public interface IVehicleDAO {
    
    public abstract Vehicle addVehicle(Vehicle vehicle) throws PersistenceException;
    public abstract Vehicle getVehicle(Long idVehicle) throws PersistenceException;
    public abstract List<Vehicle> getAllVehicles() throws PersistenceException;
    public abstract Vehicle updateVehicle(Vehicle vehicle) throws PersistenceException;
}
