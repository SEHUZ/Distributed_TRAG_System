
package presentacion.interfaces.vistas;

import dtos.cotizacion.CotizacionResumenDTO;
import dtos.insumos.InsumoResumenDTO;
import dtos.servicio.ServicioDetalleDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 *
 * Archivo: IVistaCrearCotizacion.java
 * 
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Yuri Germán García López - 253080
 * @author Manuel Romo López - 253080
 * 
 */
public interface IVistaCrearCotizacion extends IVista{
    
    public abstract void cargarServicioSeleccionado(ServicioDetalleDTO servicio);
    public abstract void actualizarSugerencias(List<InsumoResumenDTO> insumos);
    public abstract void agregarInsumoTabla(InsumoResumenDTO insumo);
    public abstract void mostrarGuardadoPdf(CotizacionResumenDTO cotizacion);
    public abstract void mostrarMensajeExito();
}
