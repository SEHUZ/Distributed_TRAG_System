/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.interfaces.backend;

import dtos.vehicle.VehicleDetailDTO;
import dtos.vehicle.VehicleSummaryDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IAdministradorAutomoviles {

    List<VehicleSummaryDTO> obtenerTodosAutomoviles() throws Exception;

    VehicleDetailDTO obtenerAutomovil(Long idAutomovil) throws Exception;
}
