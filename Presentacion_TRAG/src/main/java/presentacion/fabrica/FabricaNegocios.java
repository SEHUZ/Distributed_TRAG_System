/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.fabrica;

import Interfaces.IAdministradorAutomoviles;
import Interfaces.IAdministradorClientes;
import Interfaces.IAdministradorInsumos;
import Interfaces.IAdministradorServicios;
import com.mycompany.administradorcotizaciones_trag.IAdministradorCotizaciones;
import com.mycompany.administradorcotizaciones_trag.FAdministradorCotizaciones;
import com.mycompany.trag.customerandvehicleclient_trag.FAdministradorAutomoviles;
import com.mycompany.trag.customerandvehicleclient_trag.FAdministradorClientes;
import Facades.FAdministradorInsumos;
import Facades.FAdministradorServicios;

/**
 *
 * @author chris
 */
public class FabricaNegocios {

    public static IAdministradorClientes obtenerAdministradorClientes() {
        return new FAdministradorClientes();
    }

    public static IAdministradorAutomoviles obtenerAdministradorAutomoviles() {
        return new FAdministradorAutomoviles();
    }

    public static IAdministradorServicios obtenerAdministradorServicios() {
        return new FAdministradorServicios();
    }

    public static IAdministradorCotizaciones obtenerAdministradorCotizaciones() {
        return new FAdministradorCotizaciones();
    }

    public static IAdministradorInsumos obtenerAdministadorInsumos() {
        return new FAdministradorInsumos();
    }
}
