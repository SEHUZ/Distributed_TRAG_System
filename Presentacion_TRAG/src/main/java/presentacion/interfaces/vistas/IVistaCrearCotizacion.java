
package presentacion.interfaces.vistas;

import dtos.quote.QuoteDetailDTO;
import dtos.quote.QuoteSummaryDTO;
import dtos.supply.SupplySummaryDTO;
import dtos.service.ServiceDetailDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 *
 * Archivo: IVistaCrearCotizacion.java
 * 
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * 
 */
public interface IVistaCrearCotizacion extends IVista {
    public void mostrarCotizacionExito(QuoteDetailDTO cotizacion);
    public void cargarDetalleServicio(ServiceDetailDTO servicio);
    public void actualizarSugerencias(List<SupplySummaryDTO> insumos);
    public void agregarInsumoTabla(SupplySummaryDTO insumoResumen);
}
