/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sonic
 */
public class Connection {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Connection_Customer&Vehicle_TRAG");
    
    /**
     * Crea una nueva conexión con la base de datos.
     * @return Objeto EntityManager.
     */
    public static EntityManager crearConexion() {
        return emf.createEntityManager(); // Se reutiliza el factory y se obtiene un nuevo EntityManager
    }
    
    /**
     * Cierra la conexión con la base de datos.
     */
    public static void cerrar() {
        if (emf.isOpen()) 
            emf.close();
    }
}
