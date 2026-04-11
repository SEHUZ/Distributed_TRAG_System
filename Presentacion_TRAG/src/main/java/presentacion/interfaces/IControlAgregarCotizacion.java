package presentacion.interfaces;

import dtos.vehicle.VehicleSummaryDTO; // Fixed
import dtos.service.ServiceSummaryDTO; // Fixed
import presentacion.borradores.BorradorCotizacion;

/**
 *
 * Archivo: IControlAgregarCotizacion.java
 *
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 *
 */
public interface IControlAgregarCotizacion {

    void iniciar();

    void seleccionarCliente(Long idCliente);

    void seleccionarAutomovil(VehicleSummaryDTO automovil);

    void seleccionarClienteAutomovil();

    void atrasPrincipal();

    void guardarDiagnosticoEstado(String diagnostico, String estado);

    void atrasDiagnosticoEstado();

    void seleccionarServicio(ServiceSummaryDTO servicio);

    void buscarServicio(String nombreServicio);

    void atrasSeleccionarServicio();

    void guardarCambioCotizacion(BorradorCotizacion cotizacion);

    void buscarInsumosNombre(String nombreInsumo);

    void agregarInsumo(String nombre);

    void crearCotizacion();

    void atrasCrearCotizacion();

    void cancelarAgregar();
}
