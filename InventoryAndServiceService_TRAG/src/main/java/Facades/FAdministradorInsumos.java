/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Interfaces.IAdministradorInsumos;
import Service.InventoryAndServiceManager;
import dtos.supply.SupplySummaryDTO;
import Exception.BusinessException;
import java.util.List;

/**
 *
 * @author chris
 */
public class FAdministradorInsumos implements IAdministradorInsumos {
    private final InventoryAndServiceManager manager = new InventoryAndServiceManager();

    @Override
    public List<SupplySummaryDTO> obtenerInsumosNombre(String nombre) throws BusinessException {
        return manager.getSuppliesByName(nombre);
    }
}
