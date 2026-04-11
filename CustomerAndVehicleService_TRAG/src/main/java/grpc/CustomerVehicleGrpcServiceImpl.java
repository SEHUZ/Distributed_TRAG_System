/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grpc;

import Service.CustomerAndVehicleManager;
import Exception.BusinessException;
import com.mycompany.grpc.CustomerVehicleServiceGrpcGrpc;
import com.mycompany.grpc.CustomerRequest;
import com.mycompany.grpc.CustomerSummaryResponse;
import com.mycompany.grpc.VehicleRequest;
import com.mycompany.grpc.VehicleSummaryResponse;
import com.mycompany.grpc.EmptyRequest;
import com.mycompany.grpc.CustomerListResponse;
import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import dtos.vehicle.VehicleDetailDTO;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author chris
 */
@Service
public class CustomerVehicleGrpcServiceImpl extends CustomerVehicleServiceGrpcGrpc.CustomerVehicleServiceGrpcImplBase {

    private final CustomerAndVehicleManager manager;

    // Inject the existing Spring service manager
    public CustomerVehicleGrpcServiceImpl(CustomerAndVehicleManager manager) {
        this.manager = manager;
    }

    @Override
    public void getCustomerSummary(CustomerRequest request, StreamObserver<CustomerSummaryResponse> responseObserver) {
        try {
            // Fetch the customer using the manager
            CustomerDetailDTO customer = manager.getCustomer(request.getCustomerId());
            
            // Build the gRPC response
            CustomerSummaryResponse response = CustomerSummaryResponse.newBuilder()
                    .setId(customer.getId()) 
                    .setFirstName(customer.getFirstName())
                    .setLastName(customer.getLastName())
                    // Handle potential nulls for middle names
                    .setSecondLastName(customer.getSecondLastName() != null ? customer.getSecondLastName() : "") 
                    .setExists(true)
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (BusinessException e) {
            // If BusinessException is thrown (not found), set exists to false
            CustomerSummaryResponse response = CustomerSummaryResponse.newBuilder()
                    .setExists(false)
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getVehicleSummary(VehicleRequest request, StreamObserver<VehicleSummaryResponse> responseObserver) {
        try {
            VehicleDetailDTO vehicle = manager.getVehicle(request.getVehicleId());
            
            VehicleSummaryResponse response = VehicleSummaryResponse.newBuilder()
                    .setId(vehicle.getId())
                    .setYear(vehicle.getYear())
                    .setLicensePlate(vehicle.getLicensePlate())
                    .setModel(vehicle.getModel())
                    .setBrand(vehicle.getBrand())
                    .setExists(true)
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (BusinessException e) {
            // If BusinessException is thrown, set exists to false
            VehicleSummaryResponse response = VehicleSummaryResponse.newBuilder()
                    .setExists(false)
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllCustomers(EmptyRequest request, StreamObserver<CustomerListResponse> responseObserver) {
        try {
            // Fetch all customers using the manager
            List<CustomerSummaryDTO> customers = manager.getAllCustomers();
            
            // Map the DTOs to the gRPC CustomerSummaryResponse
            List<CustomerSummaryResponse> protoCustomers = customers.stream()
                .map(dto -> CustomerSummaryResponse.newBuilder()
                        .setId(dto.getId())
                        .setFirstName(dto.getFirstName())
                        .setLastName(dto.getLastName())
                        .setSecondLastName(dto.getSecondLastName() != null ? dto.getSecondLastName() : "")
                        .setExists(true)
                        .build())
                .collect(Collectors.toList());

            // Build the list response
            CustomerListResponse response = CustomerListResponse.newBuilder()
                    .addAllCustomers(protoCustomers)
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (BusinessException e) {
            // Return an empty list if there's a persistence error
            responseObserver.onNext(CustomerListResponse.newBuilder().build());
            responseObserver.onError(io.grpc.Status.INTERNAL
                .withDescription(e.getMessage())
                .asRuntimeException());
        }
    }
}
