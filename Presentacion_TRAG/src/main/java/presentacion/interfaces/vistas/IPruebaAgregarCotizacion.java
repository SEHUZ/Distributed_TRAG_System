
package presentacion.interfaces.vistas;

import presentacion.borradores.BorradorCotizacion;
import presentacion.interfaces.IVista;

/**
 *
 * Archivo: IPruebaAgregarCotizacion.java
 * 
 * @author Ariel Eduardo Borbón Izaguirre - 253080
 * @author Sebastián Bórquez Huerta - 253080
 * @author Chris Fitch Lopez - 252379
 * 
 */
public interface IPruebaAgregarCotizacion extends IVista{
    
    public abstract void mostrarCotizacionGuardada(BorradorCotizacion borradorCotizacion);
    
}
