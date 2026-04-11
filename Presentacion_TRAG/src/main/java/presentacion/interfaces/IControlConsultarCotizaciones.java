package presentacion.interfaces;

import dtos.quote.QuoteSummaryDTO;
import java.time.LocalDateTime;
import presentacion.borradores.BorradorCotizacion;

/**
 *
 * Archivo: IControlConsultarCotizaciones.java
 *
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 *
 */
public interface IControlConsultarCotizaciones {

    public abstract void iniciar();

    public abstract void buscarCotizaciones(String nombreCliente, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estado);

    public abstract void cancelarCotizacion(Long idCotizacion);

    public abstract void activiarCotizacion(Long idCotizacion);

    void verDetalleCotizacion(QuoteSummaryDTO cotizacion);
    
    void seleccionarCotizacion(QuoteSummaryDTO cotizacion);
    
    void atrasPrincipal();
        
    void atrasHistorial();
    
    void guardarCambiosCotizacion(BorradorCotizacion cotizacion);

    public abstract void volverHistorialCotizaciones();

    public abstract void volverConsultarCotizacion();

    public abstract void cancelarConsultarCotizacion();

    public abstract void guardarCambioCotizacion(BorradorCotizacion cotizacion);

    public abstract void buscarInsumosNombre(String nombreInsumo);

    public abstract void agregarInsumo(String nombre);

    public abstract void actualizarCotizacion();

    public abstract void aceptarExitoActualizacionCotizacion();

}
