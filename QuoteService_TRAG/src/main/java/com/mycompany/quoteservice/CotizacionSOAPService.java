/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quoteservice;

import com.mycompany.quoteservice.CalculateQuoteResponse;
import com.mycompany.grpc.CustomerVehicleServiceGrpcGrpc;
import com.mycompany.grpc.CustomerRequest;
import com.mycompany.grpc.CustomerSummaryResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.annotation.PreDestroy;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author chris
 */
@Endpoint
public class CotizacionSOAPService {

    // Asegúrate de que este namespace coincida exactamente con el targetNamespace de tu cotizacion_schema.xsd
    private static final String NAMESPACE_URI = "http://mycompany.com/quoteservice";
    private ManagedChannel customerChannel;
    private CustomerVehicleServiceGrpcGrpc.CustomerVehicleServiceGrpcBlockingStub customerStub;

    public CotizacionSOAPService() {
        // Conexión gRPC hacia el CustomerAndVehicleService
        this.customerChannel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
                
        this.customerStub = CustomerVehicleServiceGrpcGrpc.newBlockingStub(customerChannel);
    }

    // Actualizamos "localPart" al nombre real de la petición generada por tu XSD
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalculateQuoteRequest")
    @ResponsePayload
    public CalculateQuoteResponse procesarCotizacion(@RequestPayload CalculateQuoteRequest request) {
        
        CalculateQuoteResponse response = new CalculateQuoteResponse();
        
        try {
            // Empaquetamos la petición gRPC usando el ID que viene en el XML SOAP.
            // OJO: Asumo que request.getClienteId() devuelve un int o long.
            CustomerRequest grpcRequest = CustomerRequest.newBuilder()
                    .setCustomerId(request.getClienteId()) // Cambiado a setCustomerId para coincidir con tu proto
                    .build();

            // Llamada gRPC a alta velocidad
            CustomerSummaryResponse grpcResponse = customerStub.getCustomerSummary(grpcRequest);

            // Validamos si el cliente existe (basado en el campo 'exists' de tu proto)
            if (grpcResponse.getExists()) {
                // NOTA: Reemplaza setTotalEstimado y setMensaje con las propiedades reales 
                // que tenga tu objeto CalculateQuoteResponse.
                System.out.println("Cliente validado exitosamente: " + grpcResponse.getFirstName());
                response.setTotalEstimado(request.getTotalEstimado());
                // Aquí en el futuro sumarás la validación del inventario
            } else {
                System.out.println("Error: El cliente no es elegible para cotizaciones o no existe.");
                response.setTotalEstimado(0.0);
            }

        } catch (Exception e) {
            System.err.println("Fallo en la comunicación interna gRPC: " + e.getMessage());
            response.setTotalEstimado(0.0);
        }
        
        return response;
    }

    @PreDestroy
    public void shutdown() {
        if (customerChannel != null && !customerChannel.isShutdown()) {
            customerChannel.shutdown();
        }
    }
}