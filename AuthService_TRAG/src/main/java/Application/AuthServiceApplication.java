/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase que inicializa el SpringBoot, levantando los servidores/puertos del
 * proyecto
 *
 * @author chris
 */
@SpringBootApplication(scanBasePackages = {"Application", "Service", "grpc"})
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
        System.out.println("--- AuthService TRAG iniciado ---");
    }
}
