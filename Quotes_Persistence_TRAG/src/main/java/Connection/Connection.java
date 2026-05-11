package Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sonic
 */
public class Connection {

    private static final String PERSISTENCE_UNIT_NAME = "com.mycompany_Quotes_Persistence_TRAG_jar_1.0PU";

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    /**
     * Crea una nueva conexión con la base de datos.
     * @return Objeto EntityManager.
     */
    public static EntityManager crearConexion() {
        return emf.createEntityManager();
    }

    /**
     * Cierra la conexión con la base de datos.
     */
    public static void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}