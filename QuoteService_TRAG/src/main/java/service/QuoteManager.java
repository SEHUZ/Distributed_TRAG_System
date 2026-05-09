package Service;

import com.mycompany.grpc.CustomerVehicleServiceGrpcGrpc;
import com.mycompany.grpc.CustomerRequest;
import com.mycompany.grpc.CustomerSummaryResponse;
import com.mycompany.grpc.VehicleRequest;
import com.mycompany.grpc.VehicleSummaryResponse;
import com.mycompany.grpc.inventory.InventoryAndServiceGrpcGrpc;
import com.mycompany.grpc.inventory.ServiceRequest;
import com.mycompany.grpc.inventory.ServiceDetailResponse;
import com.mycompany.grpc.inventory.SupplyItemResponse;
import Daos.QuoteDAO;
import Entitys.Quote;
import Entitys.QuoteSupply;
import Enums.QuoteStatus;
import Exception.BusinessException;
import Exception.PersistenceException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Service;

/**
 *
 * @author sonic
 * 
 */
@Service
public class QuoteManager {

    private final ManagedChannel customerChannel;
    private final CustomerVehicleServiceGrpcGrpc.CustomerVehicleServiceGrpcBlockingStub customerStub;

    private final ManagedChannel inventoryChannel;
    private final InventoryAndServiceGrpcGrpc.InventoryAndServiceGrpcBlockingStub inventoryStub;

    private final QuoteDAO quoteDAO;

    public QuoteManager() {
        this.customerChannel = ManagedChannelBuilder
                .forAddress("localhost", 9081)
                .usePlaintext()
                .build();
        this.customerStub = CustomerVehicleServiceGrpcGrpc.newBlockingStub(customerChannel);

        this.inventoryChannel = ManagedChannelBuilder
                .forAddress("localhost", 9082)
                .usePlaintext()
                .build();
        this.inventoryStub = InventoryAndServiceGrpcGrpc.newBlockingStub(inventoryChannel);

        this.quoteDAO = new QuoteDAO();
    }


    public Quote crearCotizacion(
            long clienteId,
            long vehiculoId,
            long serviceId,
            String vehicleStatus,
            String generalDiagnosis) throws BusinessException, PersistenceException {

        CustomerSummaryResponse customerResp = validarCliente(clienteId);
        VehicleSummaryResponse vehicleResp = validarVehiculo(vehiculoId);
        ServiceDetailResponse serviceResp = obtenerServicio(serviceId);

        double laborCost  = serviceResp.getSuggestedLaborCost();
        double supplyCost = serviceResp.getSuppliesList().stream()
                .mapToDouble(s -> s.getSuggestedCost() * s.getDefaultQuantity())
                .sum();
        double total = laborCost + supplyCost;

        Quote quote = construirQuote(
                clienteId, vehiculoId, serviceId,
                laborCost, vehicleStatus, generalDiagnosis,
                serviceResp.getSuppliesList());

        Quote saved = quoteDAO.addQuote(quote);
        saved.setLaborPrice(BigDecimal.valueOf(total));
        return saved;
    }

    public Quote obtenerCotizacion(Long id) throws BusinessException, PersistenceException {
        Quote quote = quoteDAO.getQuote(id);
        if (quote == null) {
            throw new BusinessException("Cotización no encontrada con ID: " + id);
        }
        return quote;
    }

    public List<Quote> obtenerTodasCotizaciones() throws PersistenceException {
        return quoteDAO.getAllQuotes();
    }

    private CustomerSummaryResponse validarCliente(long clienteId) throws BusinessException {
        try {
            CustomerSummaryResponse resp = customerStub.getCustomerSummary(
                    CustomerRequest.newBuilder().setCustomerId(clienteId).build());
            if (!resp.getExists()) {
                throw new BusinessException("Cliente no encontrado o inactivo con ID: " + clienteId);
            }
            return resp;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Error gRPC con CustomerAndVehicleService: " + e.getMessage());
        }
    }

    private VehicleSummaryResponse validarVehiculo(long vehiculoId) throws BusinessException {
        try {
            VehicleSummaryResponse resp = customerStub.getVehicleSummary(
                    VehicleRequest.newBuilder().setVehicleId(vehiculoId).build());
            if (!resp.getExists()) {
                throw new BusinessException("Vehículo no encontrado o inactivo con ID: " + vehiculoId);
            }
            return resp;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Error gRPC con CustomerAndVehicleService (vehículo): " + e.getMessage());
        }
    }

    private ServiceDetailResponse obtenerServicio(long serviceId) throws BusinessException {
        try {
            ServiceDetailResponse resp = inventoryStub.getServiceDetail(
                    ServiceRequest.newBuilder().setServiceId(serviceId).build());
            if (!resp.getExists()) {
                throw new BusinessException("Servicio no encontrado con ID: " + serviceId);
            }
            return resp;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Error gRPC con InventoryAndServiceService: " + e.getMessage());
        }
    }

    private Quote construirQuote(
            long clienteId, long vehiculoId, long serviceId,
            double laborCost, String vehicleStatus, String generalDiagnosis,
            List<SupplyItemResponse> supplies) {

        Quote quote = new Quote();
        quote.setServiceId(serviceId);
        quote.setCustomerId(clienteId);
        quote.setVehicleId(vehiculoId);
        quote.setLaborPrice(BigDecimal.valueOf(laborCost));
        quote.setStatus(QuoteStatus.ENABLED);
        quote.setCreatedAt(LocalDateTime.now());
        quote.setActive(true);

        if (vehicleStatus != null && !vehicleStatus.isBlank()) {
            quote.setVehicleStatus(vehicleStatus);
        }
        if (generalDiagnosis != null && !generalDiagnosis.isBlank()) {
            quote.setGeneralDiagnosis(generalDiagnosis);
        }

        List<QuoteSupply> quoteSupplies = new ArrayList<>();
        for (SupplyItemResponse s : supplies) {
            QuoteSupply qs = new QuoteSupply();
            qs.setSupplyId(s.getSupplyId());
            qs.setQuantityRequired(s.getDefaultQuantity());
            qs.setPrice(BigDecimal.valueOf(s.getSuggestedCost()));
            qs.setActive(true);
            qs.setQuote(quote);
            quoteSupplies.add(qs);
        }
        quote.setQuoteSupplies(quoteSupplies);

        return quote;
    }

    @PreDestroy
    public void shutdown() {
        if (customerChannel != null && !customerChannel.isShutdown()) customerChannel.shutdown();
        if (inventoryChannel != null && !inventoryChannel.isShutdown()) inventoryChannel.shutdown();
    }
}
