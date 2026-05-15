/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.utils;

/**
 *
 * @author PC Gamer
 */
public class Sesion {

    private static String tokenActual = null;

    public static String getToken() {
        return tokenActual;
    }

    public static void setToken(String token) {
        tokenActual = token;
    }

    public static boolean estaLogueado() {
        return tokenActual != null && !tokenActual.isEmpty();
    }

    public static void cerrarSesion() {
        tokenActual = null;
    }
}
