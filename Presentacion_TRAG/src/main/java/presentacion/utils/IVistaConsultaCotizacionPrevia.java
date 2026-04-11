package presentacion.utils;

import dtos.quote.QuoteSummaryDTO;
import dtos.quoteSupply.QuoteSupplyDetailDTO;
import dtos.supply.SupplyDetailDTO;
import dtos.supply.SupplySummaryDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * @author Yuri Germán García López - 253080
 * @author Manuel Romo López - 253080
 */
public interface IVistaConsultaCotizacionPrevia extends IVista {

    public abstract void cargarDatosCotizacion(QuoteSummaryDTO cotizacion);

    public abstract void mostrarMensajeRapido(String mensaje);

    public abstract void mostrarInsumosBuscados(List<SupplySummaryDTO> insumos);

    public abstract void aniadirInsumo(SupplySummaryDTO insumo);

    public abstract void eliminarInsumo(SupplySummaryDTO insumo);

    public abstract void guardarInsumo(SupplySummaryDTO insumo);

    public List<QuoteSupplyDetailDTO> obtenerInsumosActuales();

}
