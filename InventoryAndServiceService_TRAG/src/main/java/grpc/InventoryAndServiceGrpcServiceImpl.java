/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grpc;

import Exception.BusinessException;
import Service.InventoryAndServiceManager;
import com.mycompany.grpc.inventory.EmptyRequest;
import com.mycompany.grpc.inventory.InventoryAndServiceGrpcGrpc;
import com.mycompany.grpc.inventory.ServiceDetailResponse;
import com.mycompany.grpc.inventory.ServiceListResponse;
import com.mycompany.grpc.inventory.ServiceRequest;
import com.mycompany.grpc.inventory.ServiceSummaryResponse;
import com.mycompany.grpc.inventory.SupplyItemResponse;
import com.mycompany.grpc.inventory.SupplyRequest;
import com.mycompany.grpc.inventory.SupplySummaryResponse;
import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import dtos.supply.SupplySummaryDTO;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.stream.Collectors;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 *
 * @author sonic
 */
@GrpcService
public class InventoryAndServiceGrpcServiceImpl extends InventoryAndServiceGrpcGrpc.InventoryAndServiceGrpcImplBase {

    private final InventoryAndServiceManager manager;

    public InventoryAndServiceGrpcServiceImpl(InventoryAndServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public void getServiceSummary(ServiceRequest request, StreamObserver<ServiceSummaryResponse> responseObserver) {
        try {
            ServiceDetailDTO service = manager.getService(request.getServiceId());

            ServiceSummaryResponse response = ServiceSummaryResponse.newBuilder()
                    .setId(service.getId())
                    .setName(service.getName())
                    .setSuggestedLaborCost(
                            service.getSuggestedLaborPrice()!= null
                            ? service.getSuggestedLaborPrice().doubleValue()
                            : 0.0)
                    .setExists(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (BusinessException e) {
            ServiceSummaryResponse response = ServiceSummaryResponse.newBuilder()
                    .setExists(false)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getServiceDetail(ServiceRequest request, StreamObserver<ServiceDetailResponse> responseObserver) {
        try {
            ServiceDetailDTO service = manager.getService(request.getServiceId());

            List<SupplyItemResponse> supplyItems = service.getServiceSupplies() != null
                    ? service.getServiceSupplies().stream()
                            .map(supply -> SupplyItemResponse.newBuilder()
                                    .setSupplyId(supply.getId())
                                    .setName(supply.getSupply().getName())
                                    .setSuggestedCost(
                                            supply.getSupply().getSuggestedPrice() != null
                                            ? supply.getSupply().getSuggestedPrice().doubleValue()
                                            : 0.0)
                                    .setDefaultQuantity(
                                            supply.getQuantityNeeded() != null
                                            ? supply.getQuantityNeeded()
                                            : 1)
                                    .build())
                            .collect(Collectors.toList()) : List.of();

            ServiceDetailResponse response = ServiceDetailResponse.newBuilder()
                    .setId(service.getId())
                    .setName(service.getName())
                    .setDescription(service.getDescription() != null ? service.getDescription() : "")
                    .setSuggestedLaborCost(
                            service.getSuggestedLaborPrice() != null
                            ? service.getSuggestedLaborPrice().doubleValue()
                            : 0.0)
                    .setIconRoute(service.getIconPath() != null ? service.getIconPath() : "")
                    .addAllSupplies(supplyItems)
                    .setExists(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (BusinessException e) {
            ServiceDetailResponse response = ServiceDetailResponse.newBuilder()
                    .setExists(false)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllServices(EmptyRequest request, StreamObserver<ServiceListResponse> responseObserver) {
        try {
            List<ServiceSummaryDTO> services = manager.getAllServices();

            List<ServiceSummaryResponse> protoServices = services.stream()
                    .map(dto -> ServiceSummaryResponse.newBuilder()
                            .setId(dto.getId())
                            .setName(dto.getName())
                            .setExists(true)
                            .build())
                    .collect(Collectors.toList());

            ServiceListResponse response = ServiceListResponse.newBuilder()
                    .addAllServices(protoServices)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (BusinessException e) {
            responseObserver.onNext(ServiceListResponse.newBuilder().build());
            responseObserver.onError(
                    io.grpc.Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException());
        }
    }

    @Override
    public void getSupplySummary(SupplyRequest request, StreamObserver<SupplySummaryResponse> responseObserver) {
        try {
            SupplySummaryDTO supply = manager.getSupply(request.getSupplyId());

            SupplySummaryResponse response = SupplySummaryResponse.newBuilder()
                    .setId(supply.getId())
                    .setName(supply.getName())
                    .setSuggestedCost(
                            supply.getSuggestedPrice() != null
                            ? supply.getSuggestedPrice().doubleValue()
                            : 0.0)
                    .setExists(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (BusinessException e) {
            SupplySummaryResponse response = SupplySummaryResponse.newBuilder()
                    .setExists(false)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

