/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.interfaces.backend;

import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IAdministradorServicios {

    List<ServiceSummaryDTO> obtenerTodosServicios() throws Exception;

    ServiceDetailDTO obtenerServicio(Long idServicio) throws Exception;

    List<ServiceSummaryDTO> obtenerServiciosNombre(String nombreServicio) throws Exception;
}
