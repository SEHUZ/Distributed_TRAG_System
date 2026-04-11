/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dtos.supply.SupplySummaryDTO;
import Exception.BusinessException;
import java.util.List;

/**
 *
 * @author chris
 */
public interface IAdministradorInsumos {
    List<SupplySummaryDTO> obtenerInsumosNombre(String nombre) throws BusinessException;
}
