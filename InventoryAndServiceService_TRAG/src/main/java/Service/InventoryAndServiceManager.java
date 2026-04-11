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

import java.util.List;

/**
 *
 * @author chris
 */
public class InventoryAndServiceManager {
    private final ServicesDAO servicesDAO;
    private final SuppliesDAO suppliesDAO;

    public InventoryAndServiceManager() {
        this.servicesDAO = new ServicesDAO();
        this.suppliesDAO = new SuppliesDAO();
    }

    public List<ServiceSummaryDTO> getAllServices() throws BusinessException {
        try {
            List<Service> services = servicesDAO.getAllServices();
            return services.stream()
                    .map(EntityMappers::toServiceSummaryDTO)
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException("Error al obtener la lista de servicios", e);
        }
    }

    public ServiceDetailDTO getService(Long id) throws BusinessException {
        try {
            Service service = servicesDAO.getService(id);
            if (service == null) throw new BusinessException("Servicio no encontrado.");
            return EntityMappers.toServiceDetailDTO(service);
        } catch (PersistenceException e) {
            throw new BusinessException("Error al obtener el detalle del servicio", e);
        }
    }

    public List<ServiceSummaryDTO> getServicesByName(String name) throws BusinessException {
        try {
            List<Service> services = servicesDAO.getServicesNames(name);
            return services.stream()
                    .map(EntityMappers::toServiceSummaryDTO)
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException("Error al buscar servicios por nombre", e);
        }
    }

    // MÉTODOS DE INSUMOS
    public List<SupplySummaryDTO> getSuppliesByName(String name) throws BusinessException {
        try {
            List<Supply> supplies = suppliesDAO.getSuppliesName(name); 
            return supplies.stream()
                    .map(EntityMappers::toSupplySummaryDTO)
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new BusinessException("Error al buscar insumos por nombre", e);
        }
    }
}