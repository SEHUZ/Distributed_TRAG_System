package presentacion.utils;

import dtos.quote.QuoteSummaryDTO;
import dtos.supply.SupplySummaryDTO;

/**
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * @author Yuri Germán García López - 253080
 * @author Manuel Romo López - 253080
 */
public interface IControlConsultaCotizacion {
    
    public abstract void iniciar(QuoteSummaryDTO cotizacionSeleccionada);
    
    public void buscarInsumos(String texto);
    
    public void seleccionarInsumo(SupplySummaryDTO insumo);
    
    public abstract void guardar();
    
    public abstract void regresar();
}
