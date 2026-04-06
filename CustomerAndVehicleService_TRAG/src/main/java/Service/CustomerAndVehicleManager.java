/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Daos.CustomerDAO;
import Daos.VehicleDAO;
import Entitys.Customer;
import Entitys.Vehicle;
import Exception.BusinessException;
import Exception.PersistenceException;
import Interfaces.ICustomerDAO;
import Interfaces.IVehicleDAO;
import dtos.customer.CustomerAddDTO;
import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import dtos.customer.CustomerUpdateDTO;
import dtos.vehicle.VehicleAddDTO;
import dtos.vehicle.VehicleDetailDTO;
import dtos.vehicle.VehicleSummaryDTO;
import java.util.ArrayList;
import java.util.List;
import mappers.DTOMappers;
import mappers.EntityMappers;
import org.springframework.stereotype.Service;

/**
 *
 * @author sonic
 */
@Service
public class CustomerAndVehicleManager {

    private final ICustomerDAO customerDAO;
    private final IVehicleDAO vehicleDAO;

    public CustomerAndVehicleManager() {
        this.customerDAO = new CustomerDAO(); 
        this.vehicleDAO = new VehicleDAO();
    }
    
    //CUSTOMER METHODS

    public CustomerDetailDTO createCustomer(CustomerAddDTO dto) throws BusinessException {
        if (dto == null) {
            throw new BusinessException("Los datos del cliente no pueden ser nulos.");
        }
        try {
            Customer entity = DTOMappers.toEntity(dto);
            Customer savedEntity = customerDAO.createCustomer(entity);
            return EntityMappers.toCustomerDetailDTO(savedEntity);
        } catch (PersistenceException e) {
            throw new BusinessException("Error al crear el cliente en la base de datos.", e);
        }
    }

    public CustomerDetailDTO getCustomer(Long customerId) throws BusinessException {
        if (customerId == null) throw new BusinessException("El ID del cliente es requerido.");
        try {
            Customer entity = customerDAO.getCustomer(customerId);
            if (entity == null) {
                throw new BusinessException("No se encontró el cliente con ID: " + customerId);
            }
            return EntityMappers.toCustomerDetailDTO(entity);
        } catch (PersistenceException e) {
            throw new BusinessException("Error al buscar el cliente.", e);
        }
    }

    public List<CustomerSummaryDTO> getAllCustomers() throws BusinessException {
        try {
            List<Customer> customers = customerDAO.getAllCustomers();
            List<CustomerSummaryDTO> dtoList = new ArrayList<>();
            for (Customer c : customers) {
                dtoList.add(EntityMappers.toCustomerSummaryDTO(c));
            }
            return dtoList;
        } catch (PersistenceException e) {
            throw new BusinessException("Error al obtener la lista de clientes.", e);
        }
    }
    
    public CustomerDetailDTO updateCustomer(CustomerUpdateDTO dto) throws BusinessException {
        if (dto == null || dto.getId() == null) {
            throw new BusinessException("Los datos de actualización o el ID del cliente son inválidos.");
        }
        try {
            // 1. Buscamos el cliente existente para no perder datos como sus vehículos
            Customer existingCustomer = customerDAO.getCustomer(dto.getId());
            if (existingCustomer == null) {
                throw new BusinessException("No se puede actualizar. Cliente no encontrado.");
            }

            if (dto.getFirstName() != null) existingCustomer.setFirstName(dto.getFirstName());
            if (dto.getLastName() != null) existingCustomer.setLastName(dto.getLastName());
            if (dto.getSecondLastName() != null) existingCustomer.setSecondLastName(dto.getSecondLastName());
            if (dto.getPhoneNumber() != null) existingCustomer.setPhoneNumber(dto.getPhoneNumber());
            if (dto.getEmail() != null) existingCustomer.setEmail(dto.getEmail());

            Customer updatedEntity = customerDAO.updateCustomer(existingCustomer);
            return EntityMappers.toCustomerDetailDTO(updatedEntity);

        } catch (PersistenceException e) {
            throw new BusinessException("Error al actualizar el cliente.", e);
        }
    }
    
    
    
    //VEHICLE METHODS
    
    public VehicleDetailDTO addVehicle(VehicleAddDTO dto) throws BusinessException {
        if (dto == null) {
            throw new BusinessException("Los datos del vehículo no pueden ser nulos.");
        }
        if (dto.getCustomerId() == null) {
            throw new BusinessException("El vehículo debe estar asociado a un cliente (customerId).");
        }
        try {
            Vehicle entity = DTOMappers.toEntity(dto);
            Vehicle savedEntity = vehicleDAO.addVehicle(entity);
            return EntityMappers.toVehicleDetailDTO(savedEntity);
        } catch (PersistenceException e) {
            throw new BusinessException("Error al registrar el vehículo.", e);
        }
    }
    
    public VehicleDetailDTO getVehicle(Long vehicleId) throws BusinessException {
        if (vehicleId == null) throw new BusinessException("El ID del vehículo es requerido.");
        try {
            Vehicle entity = vehicleDAO.getVehicle(vehicleId);
            if (entity == null) {
                throw new BusinessException("No se encontró el vehículo con ID: " + vehicleId);
            }
            return EntityMappers.toVehicleDetailDTO(entity);
        } catch (PersistenceException e) {
            throw new BusinessException("Error al buscar el vehículo.", e);
        }
    }
    
    public List<VehicleSummaryDTO> getAllVehicles() throws BusinessException {
        try {
            List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
            List<VehicleSummaryDTO> dtoList = new ArrayList<>();
            for (Vehicle v : vehicles) {
                dtoList.add(EntityMappers.toVehicleSummaryDTO(v));
            }
            return dtoList;
        } catch (PersistenceException e) {
            throw new BusinessException("Error al obtener la lista de vehículos.", e);
        }
    }
}
