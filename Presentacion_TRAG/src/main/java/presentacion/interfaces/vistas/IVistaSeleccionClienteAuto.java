package presentacion.interfaces.vistas;

import dtos.vehicle.VehicleSummaryDTO;
import dtos.customer.CustomerSummaryDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 *
 * Archivo: IVistaSeleccionClienteAuto.java
 *
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 *
 */
public interface IVistaSeleccionClienteAuto extends IVista {

    public void cargarClientes(List<CustomerSummaryDTO> clientes);

    public void cargarAutosCliente(List<VehicleSummaryDTO> automoviles);

    void cargarClientes(List<CustomerSummaryDTO> clientes, Long idSeleccionado);

    void cargarAutosCliente(List<VehicleSummaryDTO> automoviles, Long idSeleccionado);
}
