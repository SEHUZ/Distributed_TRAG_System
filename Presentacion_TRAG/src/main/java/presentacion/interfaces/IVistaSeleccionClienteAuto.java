/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.interfaces;

import dtos.vehicle.VehicleSummaryDTO;
import dtos.customer.CustomerSummaryDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 *
 * @author chris
 */
public interface IVistaSeleccionClienteAuto {

    public void cargarClientes(List<CustomerSummaryDTO> clientes);

    public void cargarClientes(List<CustomerSummaryDTO> clientes, Long idSeleccionado);

    public void cargarAutosCliente(List<VehicleSummaryDTO> automoviles);

    public void cargarAutosCliente(List<VehicleSummaryDTO> automoviles, Long idSeleccionado);
}
