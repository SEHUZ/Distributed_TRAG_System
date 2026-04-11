
package presentacion.interfaces.vistas;

import dtos.service.ServiceSummaryDTO;
import java.util.List;
import presentacion.interfaces.IVista;

/**
 *
 * Archivo: IVistaServicios.java
 * 
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * 
 */
public interface IVistaServicios extends IVista {
    public void cargarServicios(List<ServiceSummaryDTO> servicios);
}
