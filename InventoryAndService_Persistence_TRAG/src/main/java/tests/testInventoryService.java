/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import Daos.ServicesDAO;
import Daos.SuppliesDAO;
import Entitys.Service;
import Entitys.ServiceSupply;
import Entitys.Supply;
import Exception.PersistenceException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class testInventoryService {

    public static void main(String[] args) throws PersistenceException {
        ServicesDAO servDAO = new ServicesDAO();
        SuppliesDAO supDAO = new SuppliesDAO();

        if (servDAO.getAllServices().isEmpty()) {
            System.out.println("Iniciando carga de catálogo base...");

            supDAO.addSupply(
                    new Supply("Evaporador", new BigDecimal("1800.00"))
            );
            supDAO.addSupply(
                    new Supply("Válvula de Expansión", new BigDecimal("450.00"))
            );
            supDAO.addSupply(
                    new Supply("Kit de O-Rings (Sellos)", new BigDecimal("15.00"))
            );
            supDAO.addSupply(
                    new Supply("Lata Gas Refrigerante R134a 500gr", new BigDecimal("300.00"))
            );

            supDAO.addSupply(
                    new Supply("Bote Aceite PAG 46/100 250ml", new BigDecimal("280.00"))
            );
            supDAO.addSupply(
                    new Supply("Sello de Flecha (Mecánico)", new BigDecimal("350.00"))
            );
            supDAO.addSupply(
                    new Supply("Rodamiento de Polea", new BigDecimal("220.00"))
            );

            supDAO.addSupply(
                    new Supply("Tramo Manguera de Barrera #8 o #10 (1m)", new BigDecimal("240.00"))
            );
            supDAO.addSupply(
                    new Supply("Férulas (Casquillos de aluminio)", new BigDecimal("45.00"))
            );
            supDAO.addSupply(
                    new Supply("Bote Limpiador de Tubería Flush", new BigDecimal("190.00"))
            );

            supDAO.addSupply(
                    new Supply("Filtro Deshidratador", new BigDecimal("550.00"))
            );
            supDAO.addSupply(
                    new Supply("Filtro de Cabina (Habitáculo)", new BigDecimal("250.00"))
            );
            supDAO.addSupply(
                    new Supply("Ampolleta de Tinte Detector UV", new BigDecimal("80.00"))
            );
            supDAO.addSupply(
                    new Supply("Bote Solvente Flush Especializado 1L", new BigDecimal("210.00"))
            );
            supDAO.addSupply(
                    new Supply("Relevador Automotriz A/C de 4/5 pines", new BigDecimal("120.00"))
            );
            supDAO.addSupply(
                    new Supply("Fusible Automotriz (varios amperajes)", new BigDecimal("10.00"))
            );
            supDAO.addSupply(
                    new Supply("Lata de Espuma Sanitizante / Ozono", new BigDecimal("180.00"))
            );

            Service serv1 = new Service();
            serv1.setName("Cambio de evaporador");

            serv1.setDescription("Esta es la intervención de mayor impacto en el cronograma del taller debido al tiempo de desarme"
                    + " y armado del tablero de instrumentos. El servicio implica la sustitución de la unidad "
                    + "de enfriamiento interna por pérdida de estanqueidad o saturación térmica irreversible."
                    + " Operativamente, requiere una gestión de tiempos crítica para no bloquear la bahía de servicio,"
                    + " asegurando que el reensamble de la consola mantenga los estándares de ajuste originales para "
                    + "evitar reclamaciones por ruidos o fallos en los controles de ventilación.");

            serv1.setSuggestedLaborCost(new BigDecimal("3500.00"));
            serv1.setIconRoute("servicio_cambio_evaporador_icono.png");

            List<ServiceSupply> list1 = new LinkedList<>();
            ServiceSupply servS1 = new ServiceSupply();
            servS1.setDefaultQuantity(1);
            servS1.setService(serv1);
            servS1.setSupply(supDAO.getSupply(2L));
            list1.add(servS1);

            ServiceSupply servS2 = new ServiceSupply();
            servS2.setDefaultQuantity(4);
            servS2.setService(serv1);
            servS2.setSupply(supDAO.getSupply(3L));
            list1.add(servS2);

            ServiceSupply servS3 = new ServiceSupply();
            servS3.setDefaultQuantity(1);
            servS3.setService(serv1);
            servS3.setSupply(supDAO.getSupply(4L));
            list1.add(servS3);

            serv1.setServiceSupplies(list1);

            servDAO.addService(serv1);

            Service serv2 = new Service();
            serv2.setName("Reparación y Servicio de Compresor");
            serv2.setDescription("Este servicio se centra en la recuperación mecánica de la unidad de potencia cuando el daño no ha comprometido"
                    + " la integridad estructural del cilindro o pistones. La labor consiste en la apertura del componente "
                    + "para corregir problemas de compresión, ruidos en rodamientos o fallos en el embrague, permitiendo una "
                    + "solución de costo intermedio frente al reemplazo total. Es una tarea que demanda precisión en el banco"
                    + " de trabajo y una verificación rigurosa de la limpieza interna para garantizar que la reparación sea "
                    + "duradera y no contamine el resto del ciclo.");
            serv2.setSuggestedLaborCost(new BigDecimal("1200.00"));
            serv2.setIconRoute("servicio_reparacion_servicio_compresor_icono.png");

            List<ServiceSupply> list2 = new LinkedList<>();

            ServiceSupply serv2_S1 = new ServiceSupply();
            serv2_S1.setDefaultQuantity(1);
            serv2_S1.setService(serv2);
            serv2_S1.setSupply(supDAO.getSupply(5L));
            list2.add(serv2_S1);

            ServiceSupply serv2_S2 = new ServiceSupply();
            serv2_S2.setDefaultQuantity(1);
            serv2_S2.setService(serv2);
            serv2_S2.setSupply(supDAO.getSupply(6L));
            list2.add(serv2_S2);

            ServiceSupply serv2_S3 = new ServiceSupply();
            serv2_S3.setDefaultQuantity(1);
            serv2_S3.setService(serv2);
            serv2_S3.setSupply(supDAO.getSupply(7L));
            list2.add(serv2_S3);

            ServiceSupply serv2_S4 = new ServiceSupply();
            serv2_S4.setDefaultQuantity(2);
            serv2_S4.setService(serv2);
            serv2_S4.setSupply(supDAO.getSupply(3L));
            list2.add(serv2_S4);

            serv2.setServiceSupplies(list2);
            servDAO.addService(serv2);

            Service serv3 = new Service();
            serv3.setName("Reconstrucción de Mangueras y Tuberías");
            serv3.setDescription("Este proceso permite la resolución inmediata de fugas en las líneas de conducción de alta y baja presión sin depender "
                    + "de la disponibilidad de refacciones de agencia. El servicio consiste en el reemplazo de los tramos de caucho "
                    + "degradados o la reparación de secciones de aluminio impactadas, manteniendo las conexiones y puertos originales. "
                    + "Para la administración del taller, es una capacidad estratégica que acelera la salida de vehículos con piezas "
                    + "descontinuadas o de importación lenta, manteniendo el flujo de trabajo constante en el área de carga.");
            serv3.setSuggestedLaborCost(new BigDecimal("800.00"));
            serv3.setIconRoute("servicio_recontruccion_tuberias_mangueras_icono.png");

            List<ServiceSupply> list3 = new LinkedList<>();

            ServiceSupply serv3_S1 = new ServiceSupply();
            serv3_S1.setDefaultQuantity(1);
            serv3_S1.setService(serv3);
            serv3_S1.setSupply(supDAO.getSupply(8L));
            list3.add(serv3_S1);

            ServiceSupply serv3_S2 = new ServiceSupply();
            serv3_S2.setDefaultQuantity(2);
            serv3_S2.setService(serv3);
            serv3_S2.setSupply(supDAO.getSupply(9L));
            list3.add(serv3_S2);

            ServiceSupply serv3_S3 = new ServiceSupply();
            serv3_S3.setDefaultQuantity(1);
            serv3_S3.setService(serv3);
            serv3_S3.setSupply(supDAO.getSupply(10L));
            list3.add(serv3_S3);

            ServiceSupply serv3_S4 = new ServiceSupply();
            serv3_S4.setDefaultQuantity(2);
            serv3_S4.setService(serv3);
            serv3_S4.setSupply(supDAO.getSupply(3L));
            list3.add(serv3_S4);

            serv3.setServiceSupplies(list3);
            servDAO.addService(serv3);

            Service serv4 = new Service();
            serv4.setName("Servicio General");
            serv4.setDescription("Mantenimiento preventivo completo del sistema frigorífico. Consiste en la inspección de líneas, "
                    + "limpieza de condensador, revisión de presiones, reemplazo del filtro deshidratador y sustitución "
                    + "de empaques esenciales. Su objetivo es preservar la vida útil del sistema y evitar fallas críticas.");
            serv4.setSuggestedLaborCost(new BigDecimal("1500.00"));
            serv4.setIconRoute("servicio_general_icono.png");

            List<ServiceSupply> list4 = new LinkedList<>();

            ServiceSupply serv4_S1 = new ServiceSupply();
            serv4_S1.setDefaultQuantity(1);
            serv4_S1.setService(serv4);
            serv4_S1.setSupply(supDAO.getSupply(11L));
            list4.add(serv4_S1);

            ServiceSupply serv4_S2 = new ServiceSupply();
            serv4_S2.setDefaultQuantity(3);
            serv4_S2.setService(serv4);
            serv4_S2.setSupply(supDAO.getSupply(3L));
            list4.add(serv4_S2);

            serv4.setServiceSupplies(list4);
            servDAO.addService(serv4);

            Service serv5 = new Service();
            serv5.setName("Recarga de Gas Refrigerante");
            serv5.setDescription("Servicio enfocado a recuperar la eficiencia térmica inyectando el fluido refrigerante exacto "
                    + "según las especificaciones técnicas del fabricante. Incluye estabilización de aceite del sistema.");
            serv5.setSuggestedLaborCost(new BigDecimal("600.00"));
            serv5.setIconRoute("servicio_recarga_gas_refrigerante_icono.png");

            List<ServiceSupply> list5 = new LinkedList<>();

            ServiceSupply serv5_S1 = new ServiceSupply();
            serv5_S1.setDefaultQuantity(2);
            serv5_S1.setService(serv5);
            serv5_S1.setSupply(supDAO.getSupply(4L));
            list5.add(serv5_S1);

            ServiceSupply serv5_S2 = new ServiceSupply();
            serv5_S2.setDefaultQuantity(1);
            serv5_S2.setService(serv5);
            serv5_S2.setSupply(supDAO.getSupply(5L));
            list5.add(serv5_S2);

            serv5.setServiceSupplies(list5);
            servDAO.addService(serv5);

            Service serv6 = new Service();
            serv6.setName("Cambio de Filtro de Cabina");
            serv6.setDescription("Reemplazo del elemento filtrante interior, vital para mantener el flujo de aire libre de "
                    + "partículas, polen, polvo y evitar obstrucciones mecánicas en el flujo hacia el evaporador.");
            serv6.setSuggestedLaborCost(new BigDecimal("350.00"));
            serv6.setIconRoute("servicio_cambio_filtro_cabina_icono.png");

            List<ServiceSupply> list6 = new LinkedList<>();

            ServiceSupply serv6_S1 = new ServiceSupply();
            serv6_S1.setDefaultQuantity(1);
            serv6_S1.setService(serv6);
            serv6_S1.setSupply(supDAO.getSupply(12L));
            list6.add(serv6_S1);

            serv6.setServiceSupplies(list6);
            servDAO.addService(serv6);

            Service serv7 = new Service();
            serv7.setName("Detección de Fugas (Nitrógeno y UV)");
            serv7.setDescription("Diagnóstico especializado para localizar microporosidades. Se presuriza el circuito con nitrógeno "
                    + "y se utiliza una ampolleta de tinte trazador UV para revelar fugas bajo luz ultravioleta.");
            serv7.setSuggestedLaborCost(new BigDecimal("450.00"));
            serv7.setIconRoute("servicio_deteccion_fugas_nitrogeno_uv_icono.png");

            List<ServiceSupply> list7 = new LinkedList<>();

            ServiceSupply serv7_S1 = new ServiceSupply();
            serv7_S1.setDefaultQuantity(1);
            serv7_S1.setService(serv7);
            serv7_S1.setSupply(supDAO.getSupply(13L));
            list7.add(serv7_S1);

            serv7.setServiceSupplies(list7);
            servDAO.addService(serv7);

            Service serv8 = new Service();
            serv8.setName("Lavado Interno del Sistema");
            serv8.setDescription("Remoción de humedad, virutas metálicas y aceite degradado tras una falla catastrófica de componentes. "
                    + "Utiliza solventes a presión para garantizar que el nuevo compresor no se contamine.");
            serv8.setSuggestedLaborCost(new BigDecimal("950.00"));
            serv8.setIconRoute("servicio_lavado_interno_sistema_icono.png");

            List<ServiceSupply> list8 = new LinkedList<>();

            ServiceSupply serv8_S1 = new ServiceSupply();
            serv8_S1.setDefaultQuantity(2);
            serv8_S1.setService(serv8);
            serv8_S1.setSupply(supDAO.getSupply(14L));
            list8.add(serv8_S1);

            ServiceSupply serv8_S2 = new ServiceSupply();
            serv8_S2.setDefaultQuantity(4);
            serv8_S2.setService(serv8);
            serv8_S2.setSupply(supDAO.getSupply(3L));
            list8.add(serv8_S2);

            serv8.setServiceSupplies(list8);
            servDAO.addService(serv8);

            Service serv9 = new Service();
            serv9.setName("Diagnóstico Eléctrico del A/C");
            serv9.setDescription("Evaluación de la red de control: sensores de presión, termistores, cableado, relevadores "
                    + "y actuadores. Ideal para fallas donde el sistema está cargado pero no realiza el acoplamiento.");
            serv9.setSuggestedLaborCost(new BigDecimal("500.00"));
            serv9.setIconRoute("servicio_diagnostico_electrico_ac_icono.png");

            List<ServiceSupply> list9 = new LinkedList<>();

            ServiceSupply serv9_S1 = new ServiceSupply();
            serv9_S1.setDefaultQuantity(1);
            serv9_S1.setService(serv9);
            serv9_S1.setSupply(supDAO.getSupply(15L));
            list9.add(serv9_S1);

            ServiceSupply serv9_S2 = new ServiceSupply();
            serv9_S2.setDefaultQuantity(2);
            serv9_S2.setService(serv9);
            serv9_S2.setSupply(supDAO.getSupply(16L));
            list9.add(serv9_S2);

            serv9.setServiceSupplies(list9);
            servDAO.addService(serv9);

            Service serv10 = new Service();
            serv10.setName("Sanitización de Ductos y Tratamiento de Ozono");
            serv10.setDescription("Erradicación de bacterias, esporas y malos olores en el circuito de ventilación interior "
                    + "utilizando una combinación de espuma activa y tratamiento con gas ozono.");
            serv10.setSuggestedLaborCost(new BigDecimal("400.00"));
            serv10.setIconRoute("servicio_sanitizacion_ductos_tratamiento_ozon_icono.png");

            List<ServiceSupply> list10 = new LinkedList<>();

            ServiceSupply serv10_S1 = new ServiceSupply();
            serv10_S1.setDefaultQuantity(1);
            serv10_S1.setService(serv10);
            serv10_S1.setSupply(supDAO.getSupply(17L));
            list10.add(serv10_S1);

            serv10.setServiceSupplies(list10);
            servDAO.addService(serv10);
            

            System.out.println("OK.");
        }
    }
}
