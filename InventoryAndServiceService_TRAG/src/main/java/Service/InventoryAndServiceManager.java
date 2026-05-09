/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Daos.ServicesDAO;
import Daos.SuppliesDAO;
import Entitys.Service;
import Entitys.Supply;
import Exception.BusinessException;
import Exception.PersistenceException;
import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import dtos.supply.SupplySummaryDTO;
import java.util.List;
import java.util.stream.Collectors;
import mappers.EntityMappers;

/**
 *
 * @author chris / sebas
 * 
 */
@org.springframework.stereotype.Service
public class InventoryAndServiceManager {

    private final ServicesDAO servicesDAO;
    private final SuppliesDAO suppliesDAO;

    public InventoryAndServiceManager() {
        this.servicesDAO = new ServicesDAO();
        this.suppliesDAO = new SuppliesDAO();
    }

    /**
     * Returns all active services from the catalog.
     */
    public List<ServiceSummaryDTO> getAllServices() throws BusinessException {
        try {
            List<Service> services = servicesDAO.getAllServices();
            return services.stream()
                    .map(EntityMappers::toServiceSummaryDTO)
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException("Error retrieving services list.", e);
        }
    }

    /**
     * Returns the complete details of a service, including its associated supplies.
     */
    public ServiceDetailDTO getService(Long id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("Service ID is required.");
        }
        try {
            Service service = servicesDAO.getService(id);
            if (service == null) {
                throw new BusinessException("Service not found with ID: " + id);
            }
            return EntityMappers.toServiceDetailDTO(service);
        } catch (PersistenceException e) {
            throw new BusinessException("Error retrieving service details.", e);
        }
    }

    /**
     * Searches for services whose name contains the given text (partial, case-insensitive search).
     */
    public List<ServiceSummaryDTO> getServicesByName(String name) throws BusinessException {
        if (name == null || name.isBlank()) {
            throw new BusinessException("Search name cannot be empty.");
        }
        try {
            List<Service> services = servicesDAO.getServicesNames(name);
            return services.stream()
                    .map(EntityMappers::toServiceSummaryDTO)
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException("Error searching services by name.", e);
        }
    }


      /**
     * Returns the details of a supply by its ID.
     * Used by the gRPC implementation to respond to QuoteService.
     */
    public SupplySummaryDTO getSupply(Long id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("Supply ID is required.");
        }
        try {
            Supply supply = suppliesDAO.getSupply(id);
            if (supply == null) {
                throw new BusinessException("Supply not found with ID: " + id);
            }
            return EntityMappers.toSupplySummaryDTO(supply);
        } catch (PersistenceException e) {
            throw new BusinessException("Error retrieving supply.", e);
        }
    }

    /**
     * Searches supplies by name (partial, case-insensitive search).
     */
    public List<SupplySummaryDTO> getSuppliesByName(String name) throws BusinessException {
        if (name == null || name.isBlank()) {
            throw new BusinessException("Search name cannot be empty.");
        }
        try {
            List<Supply> supplies = suppliesDAO.getSuppliesName(name);
            return supplies.stream()
                    .map(EntityMappers::toSupplySummaryDTO)
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException("Error searching supplies by name.", e);
        }
    }
}
