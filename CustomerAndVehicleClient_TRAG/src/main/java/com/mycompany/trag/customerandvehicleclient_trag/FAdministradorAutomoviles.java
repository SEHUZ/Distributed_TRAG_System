/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trag.customerandvehicleclient_trag;

import Interfaces.IAdministradorAutomoviles;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.mycompany.grpc.CustomerVehicleServiceGrpcGrpc;
import com.mycompany.grpc.VehicleRequest;
import com.mycompany.grpc.VehicleSummaryResponse;
import dtos.vehicle.VehicleSummaryDTO;

/**
 *
 * @author chris
 */
public class FAdministradorAutomoviles implements IAdministradorAutomoviles {

    private final CustomerVehicleServiceGrpcGrpc.CustomerVehicleServiceGrpcBlockingStub blockingStub;

    public FAdministradorAutomoviles() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        blockingStub = CustomerVehicleServiceGrpcGrpc.newBlockingStub(channel);
    }

    public VehicleSummaryDTO obtenerAutomovilPorId(Long id) {
        VehicleRequest request = VehicleRequest.newBuilder()
                .setVehicleId(id)
                .build();
        VehicleSummaryResponse response = blockingStub.getVehicleSummary(request);

        VehicleSummaryDTO dto = new VehicleSummaryDTO(
                response.getId(),
                response.getYear(),
                response.getLicensePlate(),
                response.getModel(),
                response.getBrand()
        );

        return dto;
    }
}
