package presentacion.controles;

import Exception.BusinessException;
import Interfaces.IAdministradorInsumos;
import com.mycompany.administradorcotizaciones_trag.IAdministradorCotizaciones;
import dtos.quote.QuoteSummaryDTO;
import dtos.quote.QuoteDetailDTO;
import dtos.quote.QuoteUpdateDTO;
import dtos.supply.SupplySummaryDTO;
import dtos.quoteSupply.QuoteSupplyUpdateDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import presentacion.fabrica.FabricaNegocios;
import java.util.List;
import java.util.stream.Collectors;
import presentacion.borradores.BorradorCotizacion;
import presentacion.borradores.BorradorInsumoCotizacion;
import presentacion.fabrica.FabricaVistas;
import presentacion.interfaces.vistas.IVistaConsultaCotizacion;
import presentacion.interfaces.vistas.IVistaHistorialCotizaciones;
import presentacion.interfaces.IControlConsultarCotizaciones;
import presentacion.interfaces.IControlCotizaciones;

/**
 *
 * Archivo: ControlConsultarCotizaciones.java
 *
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * @author Yuri Germán García López - 253080
 * @author Manuel Romo López - 253080
 *
 */
public class ControlConsultarCotizaciones implements IControlConsultarCotizaciones {

    private final IAdministradorCotizaciones administradorCotizaciones;
    private final IAdministradorInsumos administradorInsumos;

    private IVistaHistorialCotizaciones vistaHistorialCotizaciones;
    private IVistaConsultaCotizacion vistaConsultaCotizacion;

    private BorradorCotizacion borradorCotizacion;
    private IControlCotizaciones controlCotizaciones;

    public ControlConsultarCotizaciones() {
        this.administradorCotizaciones = FabricaNegocios.obtenerAdministradorCotizaciones();
        this.administradorInsumos = FabricaNegocios.obtenerAdministadorInsumos();
    }

    public void setControlCotizaciones(IControlCotizaciones controlCotizaciones) {
        this.controlCotizaciones = controlCotizaciones;
    }

    @Override
    public void iniciar() {
        this.vistaHistorialCotizaciones = FabricaVistas.obtenerVistaHistorialCotizaciones(this);

        // Al arrancar la pantalla, traemos todas las cotizaciones sin filtros
        buscarCotizaciones(null, null, null, "Todos");

        this.vistaHistorialCotizaciones.mostrar();
    }

    @Override
    public void buscarCotizaciones(String nombreCliente, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estado) {
        try {
            List<QuoteSummaryDTO> lista = administradorCotizaciones.obtenerTodasCotizaciones();

            if (nombreCliente != null && !nombreCliente.trim().isEmpty()) {
                String busqueda = nombreCliente.trim().toLowerCase();
                lista = lista.stream()
                        .filter(c -> {
                            String nom = c.getCustomerFirstName() != null ? c.getCustomerFirstName().toLowerCase() : "";
                            String ape = c.getCustomerLastName() != null ? c.getCustomerLastName().toLowerCase() : "";
                            return nom.contains(busqueda) || ape.contains(busqueda);
                        })
                        .collect(Collectors.toList());
            }

            if (fechaInicio != null || fechaFin != null) {
                final LocalDateTime inicioAjustada = (fechaInicio != null) ? fechaInicio.withHour(0).withMinute(0).withSecond(0).withNano(0) : null;
                final LocalDateTime finAjustada = (fechaFin != null) ? fechaFin.withHour(23).withMinute(59).withSecond(59).withNano(999999999) : null;

                lista = lista.stream()
                        .filter(c -> {
                            
                            if (c.getCreationDate() == null) { 
                                return false;
                            }
                            boolean cumpleInicio = (inicioAjustada == null) || !c.getCreationDate().isBefore(inicioAjustada);
                            boolean cumpleFin = (finAjustada == null) || !c.getCreationDate().isAfter(finAjustada);
                            return cumpleInicio && cumpleFin;
                        })
                        .collect(Collectors.toList());
            }

            if (estado != null && !estado.equalsIgnoreCase("Todos") && !estado.isEmpty()) {
                lista = lista.stream()
                        .filter(c -> c.getStatus() != null && c.getStatus().name().equalsIgnoreCase(estado))
                        .collect(Collectors.toList());
            }

            vistaHistorialCotizaciones.mostrarCotizaciones(lista); 

        } catch (Exception ex) {
            vistaHistorialCotizaciones.mostrarMensajeRapido("Error al filtrar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void cancelarCotizacion(Long idCotizacion) {
        try {
            administradorCotizaciones.eliminarCotizacion(idCotizacion);
            buscarCotizaciones(null, null, null, "Todos");
        } catch (BusinessException ex) {
            vistaHistorialCotizaciones.mostrarMensajeRapido("Error al deshabilitar la cotización");
        }
    }

    @Override
    public void activiarCotizacion(Long idCotizacion) {
        try {
            administradorCotizaciones.habilitarCotizacion(idCotizacion);
            buscarCotizaciones(null, null, null, "Todos");
        } catch (BusinessException ex) {
            vistaHistorialCotizaciones.mostrarMensajeRapido("Error al habilitar la cotización");
        }
    }

    @Override
    public void verDetalleCotizacion(QuoteSummaryDTO seleccionada) {
        try {
            QuoteDetailDTO cotizacion = administradorCotizaciones.obtenerCotizacion(seleccionada.getId());
            if (cotizacion.getStatus() != null && cotizacion.getStatus().name().equalsIgnoreCase("ACTIVA")) {
                cotizacion.getQuoteSupplies().removeIf(insumo -> !insumo.isActive());
            }
            this.vistaConsultaCotizacion = FabricaVistas.obtenerVistaConsultarCotizacion(this);
            this.vistaConsultaCotizacion.cargarDetalleCotizacion(cotizacion);
            this.vistaConsultaCotizacion.mostrar();
        } catch (BusinessException ex) {
            vistaHistorialCotizaciones.mostrarMensaje(ex.getMessage());
        }
    }

    @Override
    public void volverHistorialCotizaciones() {
        vistaHistorialCotizaciones.ocultar();
        controlCotizaciones.administrarCotizaciones();
    }

    @Override
    public void volverConsultarCotizacion() {
        vistaConsultaCotizacion.ocultar();
        vistaHistorialCotizaciones.mostrar();
    }

    @Override
    public void cancelarConsultarCotizacion() {
        vistaConsultaCotizacion.ocultar();
        controlCotizaciones.administrarCotizaciones();
    }

    @Override
    public void guardarCambioCotizacion(BorradorCotizacion cotizacion) {
        borradorCotizacion = cotizacion;
    }

    @Override
    public void buscarInsumosNombre(String nombreInsumo) {
        try {
            List<SupplySummaryDTO> insumos = administradorInsumos.obtenerInsumosNombre(nombreInsumo);
            vistaConsultaCotizacion.actualizarSugerencias(insumos);
        } catch (BusinessException e) {
            vistaConsultaCotizacion.mostrarMensaje(e.getMessage());
        }
    }
    

    @Override
    public void agregarInsumo(String nombre) {
        try {
            List<SupplySummaryDTO> insumos = administradorInsumos.obtenerInsumosNombre(nombre);
            for (SupplySummaryDTO insumo : insumos) {
                if (insumo.getName().equals(nombre)) {
                    vistaConsultaCotizacion.agregarInsumoTabla(insumo);
                }
            }
        } catch (BusinessException e) {
            vistaConsultaCotizacion.mostrarMensaje(e.getMessage());
        }
    }

    @Override
    public void actualizarCotizacion() {
        if (borradorCotizacion == null) {
            vistaConsultaCotizacion.mostrarMensaje("No hay cambios pendientes para guardar.");
            return;
        }

        List<QuoteSupplyUpdateDTO> insumosCotizacion = new ArrayList<>();

        try {
            QuoteDetailDTO cotizacionExistente = administradorCotizaciones.obtenerCotizacion(borradorCotizacion.getId());

            for (BorradorInsumoCotizacion borradorInsumo : borradorCotizacion.getBorradoresInsumoCotizacion()) {
                insumosCotizacion.add(new QuoteSupplyUpdateDTO(
                        borradorInsumo.getCantidad(),
                        borradorInsumo.getCosto(),
                        borradorCotizacion.getId(),
                        borradorInsumo.getIdInsumo()
                ));
            }

            QuoteUpdateDTO cotizacionActualizar = new QuoteUpdateDTO( // error "cannot find symbol"
                    borradorCotizacion.getId(),
                    borradorCotizacion.getCostoManoObra(),
                    cotizacionExistente.getDiagnostic(), // error "cannot find symbol"
                    cotizacionExistente.getVehicleState(), // error "cannot find symbol"
                    insumosCotizacion 
            );

            QuoteDetailDTO cotizacionActualizada = administradorCotizaciones.actualizarCotizacion(cotizacionActualizar);

            if (cotizacionActualizada != null) {
                vistaConsultaCotizacion.mostrarMensajeExito();
            }

        } catch (BusinessException ex) {
            vistaConsultaCotizacion.mostrarMensaje(ex.getMessage());
        } catch (Exception e) {
            vistaConsultaCotizacion.mostrarMensaje("Ocurrió un error inesperado al actualizar.");
            e.printStackTrace();
        }
    }

    @Override
    public void aceptarExitoActualizacionCotizacion() {
        vistaConsultaCotizacion.ocultar();
        controlCotizaciones.administrarCotizaciones();
    }


    @Override
    public void seleccionarCotizacion(QuoteSummaryDTO cotizacion) {
        // Implementación requerida por la interfaz
    }

    @Override
    public void atrasPrincipal() {
        // Implementación requerida por la interfaz
    }

    @Override
    public void atrasHistorial() {
        // Implementación requerida por la interfaz
    }

    @Override
    public void guardarCambiosCotizacion(BorradorCotizacion cotizacion) {
        // Implementación requerida por la interfaz
    }
}

