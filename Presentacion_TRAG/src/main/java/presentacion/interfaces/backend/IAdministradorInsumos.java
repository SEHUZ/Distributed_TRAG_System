/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.interfaces.backend;

import dtos.supply.SupplySummaryDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IAdministradorInsumos {

    List<SupplySummaryDTO> obtenerInsumosNombre(String nombreInsumo) throws Exception;
}
