package presentacion.controles;

import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import dtos.quote.QuoteAddDTO;
import dtos.quote.QuoteDetailDTO;
import dtos.quoteSupply.QuoteSupplyAddDTO;
import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import dtos.supply.SupplySummaryDTO;
import dtos.vehicle.VehicleSummaryDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import presentacion.borradores.BorradorAutomovil;
import presentacion.borradores.BorradorCliente;
import presentacion.borradores.BorradorCotizacion;
import presentacion.borradores.BorradorInsumoCotizacion;
import presentacion.borradores.BorradorServicio;
import presentacion.fabrica.FabricaNegocios;
import presentacion.fabrica.FabricaVistas;
import presentacion.interfaces.IControlAgregarCotizacion;
import presentacion.interfaces.IControlCotizaciones;
import presentacion.interfaces.backend.IAdministradorAutomoviles;
import presentacion.interfaces.backend.IAdministradorClientes;
import presentacion.interfaces.backend.IAdministradorCotizaciones;
import presentacion.interfaces.backend.IAdministradorInsumos;
import presentacion.interfaces.backend.IAdministradorServicios;
import presentacion.interfaces.vistas.IVistaCrearCotizacion;
import presentacion.interfaces.vistas.IVistaDiagnosticoEstado;
import presentacion.interfaces.vistas.IVistaSeleccionClienteAuto;
import presentacion.interfaces.vistas.IVistaServicios;




/*
 * Archivo: ControlAgregarCotizacion.java
 * 
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * @author Yuri Germán García López - 253080
 * @author Manuel Romo López - 253080
 * 
 */
public class ControlAgregarCotizacion implements IControlAgregarCotizacion {

    private IAdministradorClientes administradorClientes;
    private IAdministradorAutomoviles administradorAutomoviles;
    private IAdministradorServicios administradorSerivicios;
    private IAdministradorCotizaciones administradorCotizaciones;
    private IAdministradorInsumos administradorInsumos;

    private IVistaSeleccionClienteAuto vistaSeleccionClienteAuto;
    private IVistaDiagnosticoEstado vistaDiagnosticoEstado;
    private IVistaServicios vistaServicios;
    private IVistaCrearCotizacion vistaCrearCotizacion;

    private BorradorCliente borradorCliente;
    private BorradorAutomovil borradorAutomovil;
    private String borradorDiagnostico;
    private String borradorEstado;
    private BorradorServicio borradorServicio;
    private BorradorCotizacion borradorCotizacion;

    private IControlCotizaciones controlCotizaciones;

    public ControlAgregarCotizacion() {
        administradorClientes = FabricaNegocios.obtenerAdministradorClientes();
        administradorAutomoviles = FabricaNegocios.obtenerAdministradorAutomoviles();
        administradorSerivicios = FabricaNegocios.obtenerAdministradorServicios();
        administradorCotizaciones = FabricaNegocios.obtenerAdministradorCotizaciones();
        administradorInsumos = FabricaNegocios.obtenerAdministadorInsumos();
    }

    public void setControlCotizaciones(IControlCotizaciones controlCotizaciones) {
        this.controlCotizaciones = controlCotizaciones;
    }

    @Override
    public void iniciar() {
        try {
            vistaSeleccionClienteAuto = FabricaVistas.obtenerVistaSeleccionClienteAuto(this);
            List<CustomerSummaryDTO> clientes = administradorClientes.obtenerTodosClientes();
            vistaSeleccionClienteAuto.cargarClientes(clientes);
            vistaSeleccionClienteAuto.mostrar();
        } catch (Exception e) {
            vistaSeleccionClienteAuto.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void atrasPrincipal() {
        borradorDiagnostico = null;
        borradorEstado = null;
        vistaSeleccionClienteAuto.ocultar();
        controlCotizaciones.administrarCotizaciones();
    }

    @Override
    public void seleccionarCliente(Long idCliente) {
        try {
            CustomerDetailDTO clienteSeleccionado = administradorClientes.obtenerCliente(idCliente);
            List<VehicleSummaryDTO> automovilesCliente = clienteSeleccionado.getVehicles();

            borradorCliente = new BorradorCliente(
                    clienteSeleccionado.getId(),
                    clienteSeleccionado.getFirstName(),
                    clienteSeleccionado.getLastName(),
                    clienteSeleccionado.getSecondLastName());

            vistaSeleccionClienteAuto.cargarAutosCliente(automovilesCliente);
        } catch (Exception e) {
            vistaSeleccionClienteAuto.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void seleccionarAutomovil(VehicleSummaryDTO automovil) {
        if (automovil != null) {
            borradorAutomovil = new BorradorAutomovil(
                    automovil.getId(),
                    automovil.getBrand(),
                    automovil.getModel(),
                    automovil.getYear(),
                    automovil.getLicensePlate()
            );
        }
    }

    @Override
    public void seleccionarClienteAutomovil() {

        vistaSeleccionClienteAuto.ocultar();
        vistaDiagnosticoEstado = FabricaVistas.obtenerVistaDiagnosticoEstado(this);

        if (borradorDiagnostico != null || borradorEstado != null) {
            vistaDiagnosticoEstado.cargarDiagnosticoEstado(borradorDiagnostico, borradorEstado);
        }

        vistaDiagnosticoEstado.mostrar();

    }

    @Override
    public void guardarDiagnosticoEstado(String diagnostico, String estado) {
        borradorDiagnostico = diagnostico;
        borradorEstado = estado;
        vistaServicios = FabricaVistas.obtenerVistaServicios(this);
        try {
            List<ServiceSummaryDTO> servicios = administradorSerivicios.obtenerTodosServicios();
            vistaServicios.cargarServicios(servicios);
            vistaDiagnosticoEstado.ocultar();
            vistaServicios.mostrar();
        } catch (Exception e) {
            vistaDiagnosticoEstado.mostrarMensaje(e.getMessage());
        }
    }

@Override
    public void atrasDiagnosticoEstado() {
        try {
            List<CustomerSummaryDTO> clientes = administradorClientes.obtenerTodosClientes();
            if (borradorCliente != null) {
                vistaSeleccionClienteAuto.cargarClientes(clientes); 
                
                CustomerDetailDTO clienteSeleccionado = administradorClientes.obtenerCliente(borradorCliente.getId());
                List<VehicleSummaryDTO> automovilesCliente = clienteSeleccionado.getVehicles(); 
                vistaDiagnosticoEstado.ocultar();
                
                if (borradorAutomovil != null) {
                    vistaSeleccionClienteAuto.cargarAutosCliente(automovilesCliente); 
                } else {
                    vistaSeleccionClienteAuto.cargarAutosCliente(automovilesCliente);
                }
            } else {
                vistaSeleccionClienteAuto.cargarClientes(clientes);
            }
            vistaSeleccionClienteAuto.mostrar();

        } catch (Exception e) { 
            vistaSeleccionClienteAuto.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void seleccionarServicio(ServiceSummaryDTO servicio) {
        borradorServicio = new BorradorServicio(servicio.getId(), servicio.getName());
        vistaCrearCotizacion = FabricaVistas.obtenerVistaCrearCotizacion(this);
        try {
            ServiceDetailDTO servicioSeleccionado = administradorSerivicios.obtenerServicio(servicio.getId());
            vistaCrearCotizacion.cargarDetalleServicio(servicioSeleccionado);
            vistaServicios.ocultar();
            vistaCrearCotizacion.mostrar();
        } catch (Exception e) {
            vistaServicios.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void buscarServicio(String nombreServicio) {

        try {
            List<ServiceSummaryDTO> servicios = administradorSerivicios.obtenerServiciosNombre(nombreServicio);
            vistaServicios.cargarServicios(servicios);

        } catch (Exception e) {
            vistaServicios.mostrarMensaje(e.getMessage());
        }

    }

    @Override
    public void atrasSeleccionarServicio() {

        if (borradorDiagnostico != null && borradorEstado != null) {

            vistaDiagnosticoEstado.cargarDiagnosticoEstado(borradorDiagnostico, borradorEstado);
            vistaServicios.ocultar();
            vistaDiagnosticoEstado.mostrar();

        }

    }

    @Override
    public void guardarCambioCotizacion(BorradorCotizacion cotizacion) {
        borradorCotizacion = cotizacion;
    }

    @Override
    public void buscarInsumosNombre(String nombreInsumo) {
        try {
            List<SupplySummaryDTO> insumos = administradorInsumos.obtenerInsumosNombre(nombreInsumo);
            vistaCrearCotizacion.actualizarSugerencias(insumos);
        } catch (Exception e) {
            vistaCrearCotizacion.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void agregarInsumo(String nombre) {
        try {
            List<SupplySummaryDTO> insumos = administradorInsumos.obtenerInsumosNombre(nombre);
            for (SupplySummaryDTO insumo : insumos) {
                if (insumo.getName().equals(nombre)) {
                    vistaCrearCotizacion.agregarInsumoTabla(insumo);
                }
            }
        } catch (Exception e) {
            vistaCrearCotizacion.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void crearCotizacion() {
        List<QuoteSupplyAddDTO> quoteSupplies = new ArrayList<>();
        for (BorradorInsumoCotizacion borradorInsumo : borradorCotizacion.getBorradoresInsumoCotizacion()) {
            quoteSupplies.add(new QuoteSupplyAddDTO(
                    borradorInsumo.getCantidad(),
                    borradorInsumo.getCosto(),
                    borradorInsumo.getIdInsumo()));
        }

        QuoteAddDTO quoteAddDTO = new QuoteAddDTO(
                borradorCotizacion.getCostoManoObra(),
                borradorEstado,
                borradorDiagnostico,
                LocalDateTime.now(),
                quoteSupplies,
                borradorServicio.getId(),
                borradorCliente.getId(),
                borradorAutomovil.getId());

        try {
            QuoteDetailDTO quoteSaved = administradorCotizaciones.crearCotizacion(quoteAddDTO); 
            if (quoteSaved != null) {
                vistaCrearCotizacion.mostrarCotizacionExito(quoteSaved); 
            }
        } catch (Exception e) {
            vistaCrearCotizacion.mostrarMensaje("Error al crear: " + e.getMessage());
        }
    }

    @Override
    public void atrasCrearCotizacion() {

        vistaCrearCotizacion.ocultar();
        vistaServicios.mostrar();

    }

    @Override
    public void cancelarAgregar() {

        borradorDiagnostico = null;
        borradorEstado = null;
        vistaCrearCotizacion.ocultar();
        controlCotizaciones.administrarCotizaciones();
    }

}
