package presentacion.interfaces.vistas;

import dtos.quote.QuoteSummaryDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 *
 * Archivo: IVistaHistorialCotizaciones.java
 *
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 *
 */
public interface IVistaHistorialCotizaciones extends IVista {

    public void cargarCotizaciones(List<QuoteSummaryDTO> cotizaciones);

    public abstract void mostrarMensajeRapido(String mensaje);

    void mostrarCotizaciones(List<QuoteSummaryDTO> cotizaciones);

    public abstract void limpiarFiltros();

}
