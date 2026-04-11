/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Interfaces.IAdministradorServicios;
import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import Exception.BusinessException;
import Service.InventoryAndServiceManager;
import java.util.List;

/**
 *
 * @author chris
 */
public class FAdministradorServicios implements IAdministradorServicios {
    private final InventoryAndServiceManager manager = new InventoryAndServiceManager();

    @Override
    public List<ServiceSummaryDTO> obtenerTodosServicios() throws BusinessException {
        return manager.getAllServices();
    }

    @Override
    public ServiceDetailDTO obtenerServicio(Long id) throws BusinessException {
        return manager.getService(id);
    }

    @Override
    public List<ServiceSummaryDTO> obtenerServiciosNombre(String nombre) throws BusinessException {
        return manager.getServicesByName(nombre);
    }
}
