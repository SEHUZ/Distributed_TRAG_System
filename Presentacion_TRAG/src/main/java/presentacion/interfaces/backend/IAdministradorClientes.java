/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.interfaces.backend;

import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IAdministradorClientes {

    List<CustomerSummaryDTO> obtenerTodosClientes() throws Exception;

    CustomerDetailDTO obtenerCliente(Long idCliente) throws Exception;
}
