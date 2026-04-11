/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import Exception.BusinessException;
import java.util.List;

/**
 *
 * @author chris
 */
public interface IAdministradorServicios {
    List<ServiceSummaryDTO> obtenerTodosServicios() throws BusinessException;
    ServiceDetailDTO obtenerServicio(Long id) throws BusinessException;
    List<ServiceSummaryDTO> obtenerServiciosNombre(String nombre) throws BusinessException;
}