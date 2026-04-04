/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entitys.Customer;
import Exceptions.PersistenceException;
import java.util.List;

/**
 *
 * @author sonic
 */
public interface ICustomerDAO {
    public abstract Customer createCustomer(Customer cliente) throws PersistenceException;
    public abstract Customer getCustomer(Long idCliente) throws PersistenceException;
    public abstract List<Customer> getAllCustomers() throws PersistenceException;
    public abstract Customer updateCustomer(Customer cliente) throws PersistenceException;
}
