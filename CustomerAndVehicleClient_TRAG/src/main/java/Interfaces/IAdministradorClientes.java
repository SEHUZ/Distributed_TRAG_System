package Interfaces;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import Exception.BusinessException;
import dtos.customer.CustomerSummaryDTO;
import dtos.customer.CustomerDetailDTO;
import java.util.List;

/**
 *
 * @author chris
 */
public interface IAdministradorClientes {
    List<CustomerSummaryDTO> obtenerTodosClientes() throws BusinessException;
    CustomerDetailDTO obtenerCliente(Long id) throws BusinessException;
}
