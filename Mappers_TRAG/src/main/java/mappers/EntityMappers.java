/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import Entitys.Customer;
import Entitys.Quote;
import Entitys.QuoteSupply;
import Entitys.Service;
import Entitys.ServiceSupply;
import Entitys.Supplier;
import Entitys.Supply;
import Entitys.Vehicle;
import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import dtos.quote.QuoteDetailDTO;
import dtos.quote.QuoteSummaryDTO;
import dtos.quoteSupply.QuoteSupplyDetailDTO;
import dtos.service.ServiceAddDTO;
import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import dtos.serviceSupply.ServiceSupplyDetailDTO;
import dtos.supply.SupplyAddDTO;
import dtos.supply.SupplyDetailDTO;
import dtos.supply.SupplySummaryDTO;
import dtos.vehicle.VehicleDetailDTO;
import dtos.vehicle.VehicleSummaryDTO;
import enums.CustomerStatusBusiness;
import enums.QuoteStatusBusiness;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sonic
 */
public class EntityMappers {

    //MAPPERS FOR QUOTE PERSISTENCE AND SERVICE
    public static QuoteDetailDTO toQuoteDetailDTO(
            Quote entity,
            String serviceName,
            CustomerSummaryDTO customerSummary,
            VehicleSummaryDTO vehicleSummary,
            List<QuoteSupplyDetailDTO> quoteSuppliesDetails) {

        if (entity == null) {
            return null;
        }

        QuoteStatusBusiness estadoNegocio = null;
        if (entity.getStatus() != null) {
            estadoNegocio = QuoteStatusBusiness.valueOf(entity.getStatus().name());
        }

        return new QuoteDetailDTO(
                entity.getId(),
                entity.getLaborPrice(),
                entity.getVehicleStatus(),
                entity.getGeneralDiagnosis(),
                entity.getCreatedAt(),
                quoteSuppliesDetails,
                serviceName,
                customerSummary,
                vehicleSummary,
                estadoNegocio
        );
    }

    public static QuoteSupplyDetailDTO toQuoteSupplyDetailDTO(QuoteSupply entity, SupplySummaryDTO supplySummary) {
        if (entity == null) {
            return null;
        }

        Long quoteId = (entity.getQuote() != null) ? entity.getQuote().getId() : null;
        boolean isActive = (entity.getActive() != null) ? entity.getActive() : true;

        return new QuoteSupplyDetailDTO(
                entity.getId(),
                entity.getQuantityRequired(),
                entity.getPrice(),
                quoteId,
                supplySummary,
                isActive
        );
    }

    public static QuoteSummaryDTO toQuoteSummaryDTO(
            Quote entity,
            CustomerSummaryDTO customerSummary,
            VehicleSummaryDTO vehicleSummary,
            List<QuoteSupplyDetailDTO> quoteSuppliesDetails) {

        if (entity == null) {
            return null;
        }

        QuoteStatusBusiness estadoNegocio = null;
        if (entity.getStatus() != null) {
            estadoNegocio = QuoteStatusBusiness.valueOf(entity.getStatus().name());
        }

        BigDecimal totalPrice = entity.getLaborPrice() != null ? entity.getLaborPrice() : BigDecimal.ZERO;
        if (quoteSuppliesDetails != null) {
            for (QuoteSupplyDetailDTO supply : quoteSuppliesDetails) {
                if (supply.getSubtotal() != null && supply.isActive()) {
                    totalPrice = totalPrice.add(supply.getSubtotal());
                }
            }
        }

        QuoteSummaryDTO dto = new QuoteSummaryDTO(
                entity.getId(),
                customerSummary != null ? customerSummary.getFirstName() : "Desconocido",
                customerSummary != null ? customerSummary.getLastName() : "",
                customerSummary != null ? customerSummary.getSecondLastName() : "",
                vehicleSummary != null ? vehicleSummary.getBrand() : "Desconocido",
                vehicleSummary != null ? vehicleSummary.getModel() : "",
                vehicleSummary != null ? vehicleSummary.getLicensePlate() : "",
                vehicleSummary != null ? vehicleSummary.getYear() : 0,
                entity.getCreatedAt(),
                entity.getLaborPrice(),
                quoteSuppliesDetails,
                estadoNegocio
        );

        dto.setTotalPrice(totalPrice);
        return dto;
    }

    //MAPPERS FOR CUSTOMER AND VEHICLE PERSISTENCE AND SERVICE
    public static CustomerSummaryDTO toCustomerSummaryDTO(Customer entity) {
        if (entity == null) {
            return null;
        }
        return new CustomerSummaryDTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getSecondLastName()
        );
    }

    public static CustomerDetailDTO toCustomerDetailDTO(Customer entity) {
        if (entity == null) {
            return null;
        }
        CustomerDetailDTO dto = new CustomerDetailDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setSecondLastName(entity.getSecondLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());

        if (entity.getStatus() != null) {
            dto.setStatus(CustomerStatusBusiness.valueOf(entity.getStatus().name()));
        }

        if (entity.getVehicles() != null) {
            dto.setVehicles(entity.getVehicles().stream()
                    .map(EntityMappers::toVehicleSummaryDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static VehicleSummaryDTO toVehicleSummaryDTO(Vehicle entity) {
        if (entity == null) {
            return null;
        }
        return new VehicleSummaryDTO(
                entity.getId(),
                entity.getYear(),
                entity.getLicensePlate(),
                entity.getModel(),
                entity.getBrand()
        );
    }

    public static VehicleDetailDTO toVehicleDetailDTO(Vehicle entity) {
        if (entity == null) {
            return null;
        }
        Long customerId = (entity.getCustomer() != null) ? entity.getCustomer().getId() : null;
        return new VehicleDetailDTO(
                entity.getId(),
                entity.getYear(),
                entity.getLicensePlate(),
                entity.getVin(),
                entity.getModel(),
                entity.getBrand(),
                customerId
        );
    }

    //MAPPERS FOR INVENTORY AND SERVICE SERVICE AND PERSISTENCE
    public static SupplySummaryDTO toSupplySummaryDTO(Supply entity) {
        if (entity == null) {
            return null;
        }
        return new SupplySummaryDTO(
                entity.getId(),
                entity.getName(),
                entity.getSuggestedCost()
        );
    }

    public static SupplyDetailDTO toSupplyDetailDTO(Supply entity) {
        if (entity == null) {
            return null;
        }
        Long supplierId = (entity.getSupplier() != null) ? entity.getSupplier().getId() : null;
        return new SupplyDetailDTO(
                entity.getId(),
                entity.getName(),
                entity.getSuggestedCost(),
                supplierId
        );
    }

    public static ServiceSummaryDTO toServiceSummaryDTO(Service entity) {
        if (entity == null) {
            return null;
        }
        return new ServiceSummaryDTO(
                entity.getId(),
                entity.getName(),
                null
        );
    }

    public static ServiceDetailDTO toServiceDetailDTO(Service entity) {
        if (entity == null) {
            return null;
        }
        ServiceDetailDTO dto = new ServiceDetailDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setSuggestedLaborPrice(entity.getSuggestedLaborCost());

        if (entity.getServiceSupplies() != null) {
            dto.setServiceSupplies(entity.getServiceSupplies().stream()
                    .map(EntityMappers::toServiceSupplyDetailDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static ServiceSupplyDetailDTO toServiceSupplyDetailDTO(ServiceSupply entity) {
        if (entity == null) {
            return null;
        }

        Long serviceId = (entity.getService() != null) ? entity.getService().getId() : null;
        SupplySummaryDTO supplyResumen = toSupplySummaryDTO(entity.getSupply());

        BigDecimal subtotal = BigDecimal.ZERO;
        if (entity.getSupply() != null && entity.getSupply().getSuggestedCost() != null && entity.getDefaultQuantity() != null) {
            subtotal = entity.getSupply().getSuggestedCost().multiply(new BigDecimal(entity.getDefaultQuantity()));
        }

        ServiceSupplyDetailDTO dto = new ServiceSupplyDetailDTO(
                entity.getId(),
                entity.getDefaultQuantity(),
                serviceId,
                supplyResumen
        );
        dto.setSubtotal(subtotal);
        return dto;
    }


    public static Supply toSupplyEntity(SupplyAddDTO dto) {
        if (dto == null) {
            return null;
        }

        Supply supply = new Supply();
        supply.setName(dto.getName());

        supply.setSuggestedCost(dto.getSuggestedPrice());

        if (dto.getSupplierId() != null) {
            Supplier supplier = new Supplier();
            supplier.setId(dto.getSupplierId());
            supply.setSupplier(supplier);
        }

        return supply;
    }


    public static Service toServiceEntity(ServiceAddDTO dto) {
        if (dto == null) {
            return null;
        }

        Service service = new Service();
        service.setName(dto.getName());
        service.setDescription(dto.getDescription());

        service.setSuggestedLaborCost(dto.getSuggestedLaborPrice());
        service.setIconRoute(dto.getIconPath());

        service.setEnabled(true);

        if (dto.getServiceSupplies() != null && !dto.getServiceSupplies().isEmpty()) {
            List<ServiceSupply> suppliesList = dto.getServiceSupplies().stream()
                    .map(supDto -> {
                        ServiceSupply serviceSupply = new ServiceSupply();

                        serviceSupply.setDefaultQuantity(supDto.getQuantityNeeded());

                        Supply supplyReference = new Supply();
                        supplyReference.setId(supDto.getSupplyId());
                        serviceSupply.setSupply(supplyReference);

                        serviceSupply.setService(service);

                        return serviceSupply;
                    })
                    .collect(Collectors.toList());

            service.setServiceSupplies(suppliesList);
        }

        return service;
    }

}
