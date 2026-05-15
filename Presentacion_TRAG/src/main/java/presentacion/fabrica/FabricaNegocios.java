/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.fabrica;

import presentacion.clienteshttp.ClienteHttpClientes;
import presentacion.clienteshttp.ClienteHttpInventario;
import presentacion.interfaces.backend.IAdministradorAutomoviles;
import presentacion.interfaces.backend.IAdministradorClientes;
import presentacion.interfaces.backend.IAdministradorCotizaciones;
import presentacion.interfaces.backend.IAdministradorInsumos;
import presentacion.interfaces.backend.IAdministradorServicios;

/**
 *
 * @author chris
 */
public class FabricaNegocios {

    public static IAdministradorClientes obtenerAdministradorClientes() {
        return new ClienteHttpClientes();
    }

    public static IAdministradorAutomoviles obtenerAdministradorAutomoviles() {
        return null;
    }

    public static IAdministradorServicios obtenerAdministradorServicios() {
        return new ClienteHttpInventario();
    }

    public static IAdministradorCotizaciones obtenerAdministradorCotizaciones() {
        return null;
    }

    public static IAdministradorInsumos obtenerAdministadorInsumos() {
        return new ClienteHttpInventario();
    }
}
