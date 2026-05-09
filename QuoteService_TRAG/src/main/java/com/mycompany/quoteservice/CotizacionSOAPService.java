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

    private static final String NAMESPACE_URI = "http://mycompany.com/quoteservice";
    private ManagedChannel customerChannel;
    private CustomerVehicleServiceGrpcGrpc.CustomerVehicleServiceGrpcBlockingStub customerStub;

    public CotizacionSOAPService() {
        this.customerChannel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
                
        this.customerStub = CustomerVehicleServiceGrpcGrpc.newBlockingStub(customerChannel);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalculateQuoteRequest")
    @ResponsePayload
    public CalculateQuoteResponse procesarCotizacion(@RequestPayload CalculateQuoteRequest request) {
        
        CalculateQuoteResponse response = new CalculateQuoteResponse();
        
        try {
            CustomerRequest grpcRequest = CustomerRequest.newBuilder()
                    .setCustomerId(request.getClienteId())
                    .build();

            CustomerSummaryResponse grpcResponse = customerStub.getCustomerSummary(grpcRequest);

            if (grpcResponse.getExists()) {
                System.out.println("Cliente validado exitosamente: " + grpcResponse.getFirstName());
                response.setTotalEstimado(request.getTotalEstimado());
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