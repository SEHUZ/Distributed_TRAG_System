/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

import Daos.CustomerDAO;
import Daos.VehicleDAO;
import Entitys.Customer;
import Entitys.Vehicle;
import Enums.CustomerStatus;
import Exception.PersistenceException;

/**
 *
 * @author sonic
 */
public class testCustomerVehicle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenceException {
        CustomerDAO customerDAO = new CustomerDAO();
        VehicleDAO vehicleDAO = new VehicleDAO();

        // customers
        Customer customer1 = new Customer();
        customer1.setFirstName("Carlos");
        customer1.setLastName("Ramírez");
        customer1.setSecondLastName("López");
        customer1.setPhoneNumber("6441234567");
        customer1.setEmail("carlos.ramirez@email.com");
        customer1.setStatus(CustomerStatus.ENABLED);

        Customer customer2 = new Customer();
        customer2.setFirstName("Ana");
        customer2.setLastName("Gutiérrez");
        customer2.setSecondLastName("Morales");
        customer2.setPhoneNumber("6449876543");
        customer2.setEmail("ana.gutierrez@email.com");
        customer2.setStatus(CustomerStatus.ENABLED);

        // 
        try {
            customer1 = customerDAO.createCustomer(customer1);
            System.out.println("Customer 1 created with id: " + customer1.getId());

            customer2 = customerDAO.createCustomer(customer2);
            System.out.println("Customer 1 created with id: " + customer2.getId());
        } catch (PersistenceException e) {
            System.err.println("Error creating customer " + e.getMessage());
            return;
        }

        // vehicles
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setYear(2020);
        vehicle1.setLicensePlate("ABC-123");
        vehicle1.setVin("1HGBH41JXMN109186");
        vehicle1.setModel("Corolla");
        vehicle1.setBrand("Toyota");
        vehicle1.setActive(true);
        vehicle1.setCustomer(customer1);   

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setYear(2018);
        vehicle2.setLicensePlate("XYZ-789");
        vehicle2.setVin("2T1BURHE0JC051823");
        vehicle2.setModel("Sentra");
        vehicle2.setBrand("Nissan");
        vehicle2.setActive(true);
        vehicle2.setCustomer(customer2);  

        
        vehicle1 = vehicleDAO.addVehicle(vehicle1);
        System.out.println("Vehículo 1 creado con ID: " + vehicle1.getId());
        vehicle2 = vehicleDAO.addVehicle(vehicle2);
        System.out.println("Vehículo 2 creado con ID: " + vehicle2.getId());


        
        try {
            Customer c1Found = customerDAO.getCustomer(customer1.getId());
            System.out.println("\n--- Customer found ---");
            System.out.println("Name : " + c1Found.getFirstName() + " " + c1Found.getLastName());
            System.out.println("Phone: " + c1Found.getPhoneNumber());
            System.out.println("Vehicles: " + c1Found.getVehicles().size());

            Vehicle v1Found = vehicleDAO.getVehicle(vehicle1.getId());
            System.out.println("\n--- Vehicle found ---");
            System.out.println("Brand/Model : " + v1Found.getBrand() + " " + v1Found.getModel());
            System.out.println("Placa        : " + v1Found.getLicensePlate());
            System.out.println("Owner  : " + v1Found.getCustomer().getFirstName());
        } catch (PersistenceException e) {
            System.err.println("Consult error: " + e.getMessage());
        }
    }
}
