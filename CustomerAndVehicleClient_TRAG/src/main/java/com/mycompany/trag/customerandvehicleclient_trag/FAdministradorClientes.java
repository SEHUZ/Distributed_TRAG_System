/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trag.customerandvehicleclient_trag;

import Exception.BusinessException;
import Interfaces.IAdministradorClientes;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.mycompany.grpc.CustomerVehicleServiceGrpcGrpc;
import com.mycompany.grpc.CustomerRequest;
import com.mycompany.grpc.CustomerSummaryResponse;
import com.mycompany.grpc.EmptyRequest;
import com.mycompany.grpc.CustomerListResponse;
import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author chris
 */
public class FAdministradorClientes implements IAdministradorClientes {

    private final CustomerVehicleServiceGrpcGrpc.CustomerVehicleServiceGrpcBlockingStub blockingStub;

   public FAdministradorClientes() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        blockingStub = CustomerVehicleServiceGrpcGrpc.newBlockingStub(channel);
    }

    public CustomerSummaryDTO obtenerClientePorId(Long id) {
        CustomerRequest request = CustomerRequest.newBuilder()
                .setCustomerId(id) 
                .build();

        CustomerSummaryResponse response = blockingStub.getCustomerSummary(request);

        CustomerSummaryDTO dto = new CustomerSummaryDTO(
                response.getId(),
                response.getFirstName(),
                response.getLastName(),
                response.getSecondLastName()
        );
        
        return dto;
    }

    @Override
    public List<CustomerSummaryDTO> obtenerTodosClientes() throws BusinessException {
        try {
            EmptyRequest request = EmptyRequest.newBuilder().build();
            
            CustomerListResponse response = blockingStub.getAllCustomers(request);
            
            List<CustomerSummaryDTO> clientes = new ArrayList<>();
            for (CustomerSummaryResponse grpcCustomer : response.getCustomersList()) {
                clientes.add(new CustomerSummaryDTO(
                        grpcCustomer.getId(),
                        grpcCustomer.getFirstName(),
                        grpcCustomer.getLastName(),
                        grpcCustomer.getSecondLastName()
                ));
            }
            
            return clientes;
        } catch (Exception e) {
            throw new BusinessException("Error fetching clients via gRPC: " + e.getMessage());
        }
    }

    @Override
    public CustomerDetailDTO obtenerCliente(Long id) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}