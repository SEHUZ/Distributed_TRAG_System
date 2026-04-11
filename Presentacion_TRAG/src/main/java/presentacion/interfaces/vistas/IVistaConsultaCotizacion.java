package presentacion.interfaces.vistas;

import dtos.quote.QuoteDetailDTO;
import dtos.supply.SupplySummaryDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 *
 * Archivo: IVistaConsultaCotizacion.java
 * 
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * @author Yuri Germán García López - 253080
 * @author Manuel Romo López - 253080
 * 
 */
public interface IVistaConsultaCotizacion extends IVista{
    public void cargarDetalleCotizacion(QuoteDetailDTO cotizacion);
    public void actualizarSugerencias(List<SupplySummaryDTO> insumos);
    public void agregarInsumoTabla(SupplySummaryDTO insumoResumen);
    public abstract void mostrarMensajeExito();
}
