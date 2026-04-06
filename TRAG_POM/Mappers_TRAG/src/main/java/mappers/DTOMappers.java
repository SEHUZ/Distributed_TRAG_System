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
import Enums.CustomerStatus;
import Enums.QuoteStatus;
import dtos.customer.CustomerAddDTO;
import dtos.customer.CustomerSummaryDTO;
import dtos.customer.CustomerUpdateDTO;
import dtos.quote.QuoteAddDTO;
import dtos.quote.QuoteDetailDTO;
import dtos.quote.QuoteSummaryDTO;
import dtos.quote.QuoteUpdateDTO;
import dtos.quoteSupply.QuoteSupplyAddDTO;
import dtos.quoteSupply.QuoteSupplyDetailDTO;
import dtos.quoteSupply.QuoteSupplyUpdateDTO;
import dtos.service.ServiceAddDTO;
import dtos.service.ServiceUpdateDTO;
import dtos.serviceSupply.ServiceSupplyAddDTO;
import dtos.supply.SupplyAddDTO;
import dtos.supply.SupplySummaryDTO;
import dtos.vehicle.VehicleAddDTO;
import dtos.vehicle.VehicleSummaryDTO;
import dtos.vehicle.VehicleUpdateDTO;
import enums.QuoteStatusBusiness;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sonic
 */
public class DTOMappers {
    
    //MAPPERS FOR QUOTE PERSISTENCE AND SERVICE

    public static Quote toEntity(QuoteAddDTO dto) {
        if (dto == null) {
            return null;
        }
        Quote entity = new Quote();
        entity.setLaborPrice(dto.getLaborPrice());
        entity.setVehicleStatus(dto.getVehicleStatus());
        entity.setGeneralDiagnosis(dto.getGeneralDiagnosis());
        entity.setCreatedAt(dto.getCreatedAt());

        entity.setServiceId(dto.getServiceId());
        entity.setCustomerId(dto.getCustomerId());
        entity.setVehicleId(dto.getVehicleId());

        if (dto.getStatus() != null) {
            entity.setStatus(QuoteStatus.valueOf(dto.getStatus().name()));
        }

        if (dto.getQuoteSupplies() != null) {
            entity.setQuoteSupplies(dto.getQuoteSupplies().stream()
                    .map(DTOMappers::toEntity)
                    .peek(qs -> qs.setQuote(entity))
                    .collect(Collectors.toList()));
        }

        return entity;
    }

    public static Quote toEntity(QuoteUpdateDTO dto) {
        if (dto == null) {
            return null;
        }
        Quote entity = new Quote();
        entity.setId(dto.getId());
        entity.setLaborPrice(dto.getLaborPrice());
        entity.setVehicleStatus(dto.getVehicleStatus());
        entity.setGeneralDiagnosis(dto.getGeneralDiagnosis());

        if (dto.getCreatedAt() != null) {
            entity.setCreatedAt(dto.getCreatedAt());
        }

        if (dto.getQuoteSupplies() != null) {
            entity.setQuoteSupplies(dto.getQuoteSupplies().stream()
                    .map(DTOMappers::toEntity)
                    .peek(qs -> qs.setQuote(entity))
                    .collect(Collectors.toList()));
        }
        return entity;
    }

    public static QuoteSupply toEntity(QuoteSupplyAddDTO dto) {
        if (dto == null) {
            return null;
        }
        QuoteSupply entity = new QuoteSupply();
        entity.setQuantityRequired(dto.getQuantityRequired());
        entity.setPrice(dto.getPrice());
        entity.setSupplyId(dto.getSupplyId());
        return entity;
    }

    public static QuoteSupply toEntity(QuoteSupplyUpdateDTO dto) {
        if (dto == null) {
            return null;
        }
        QuoteSupply entity = new QuoteSupply();
        entity.setQuantityRequired(dto.getQuantityRequired());
        entity.setPrice(dto.getPrice());
        entity.setSupplyId(dto.getSupplyId());

        if (dto.getQuoteId() != null) {
            Quote parentQuote = new Quote();
            parentQuote.setId(dto.getQuoteId());
            entity.setQuote(parentQuote);
        }
        return entity;
    }
    
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
                customerSummary != null ? customerSummary.getFirstName() : "Unknown",
                customerSummary != null ? customerSummary.getLastName() : "",
                customerSummary != null ? customerSummary.getSecondLastName() : "",
                vehicleSummary != null ? vehicleSummary.getBrand() : "Unknown",
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

    public static QuoteSupplyDetailDTO toQuoteSupplyDetailDTO(QuoteSupply entity, SupplySummaryDTO supplySummary) {
        if (entity == null) {
            return null;
        }
        
        Long quoteId = (entity.getQuote() != null) ? entity.getQuote().getId() : null;
        boolean isActive = (entity.getActive() != null) ? entity.getActive() : true;
        
        BigDecimal subtotal = BigDecimal.ZERO;
        if (entity.getPrice() != null && entity.getQuantityRequired() != null) {
            subtotal = entity.getPrice().multiply(new BigDecimal(entity.getQuantityRequired()));
        }

        QuoteSupplyDetailDTO dto = new QuoteSupplyDetailDTO(
                entity.getId(),
                entity.getQuantityRequired(),
                entity.getPrice(),
                quoteId,
                supplySummary,
                isActive
        );
        
        dto.setSubtotal(subtotal);
        return dto;
    }
    
    
    
    //MAPPERS FOR CUSTOMER AND VEHICLE PERSISTENCE AND SERVICE
    
    public static Customer toEntity(CustomerAddDTO dto) {
        if (dto == null) return null;
        Customer entity = new Customer();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSecondLastName(dto.getSecondLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        
        if (dto.getStatus() != null) {
            entity.setStatus(CustomerStatus.valueOf(dto.getStatus().name()));
        }
        return entity;
    }

    public static Customer toEntity(CustomerUpdateDTO dto) {
        if (dto == null) return null;
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSecondLastName(dto.getSecondLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public static Vehicle toEntity(VehicleAddDTO dto) {
        if (dto == null) return null;
        Vehicle entity = new Vehicle();
        entity.setYear(dto.getYear());
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setVin(dto.getVin());
        entity.setModel(dto.getModel());
        entity.setBrand(dto.getBrand());
        
        if (dto.getCustomerId() != null) {
            entity.setCustomer(new Customer(dto.getCustomerId()));
        }
        return entity;
    }

    public static Vehicle toEntity(VehicleUpdateDTO dto) {
        if (dto == null) return null;
        Vehicle entity = new Vehicle();
        entity.setId(dto.getId());
        entity.setYear(dto.getYear());
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setVin(dto.getVin());
        entity.setModel(dto.getModel());
        entity.setBrand(dto.getBrand());
        
        if (dto.getCustomerId() != null) {
            entity.setCustomer(new Customer(dto.getCustomerId()));
        }
        return entity;
    }
    
    
    
    
    
    
    
    
    
    
    //MAPPERS FOR INVENTORY AND SERVICE SERVICE AND PERSISTENCE
    public static Supply toEntity(SupplyAddDTO dto) {
        if (dto == null) return null;
        Supply entity = new Supply();
        entity.setName(dto.getName());
        entity.setSuggestedCost(dto.getSuggestedPrice()); // Asumiendo que va al precio de venta
        
        if (dto.getSupplierId() != null) {
            entity.setSupplier(new Supplier(dto.getSupplierId()));
        }
        return entity;
    }

    public static Service toEntity(ServiceAddDTO dto) {
        if (dto == null) return null;
        Service entity = new Service();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setSuggestedLaborCost(dto.getSuggestedLaborPrice());
        entity.setIconRoute(dto.getIconPath());
        
        if (dto.getServiceSupplies() != null) {
            entity.setServiceSupplies(dto.getServiceSupplies().stream()
                    .map(DTOMappers::toEntity)
                    .peek(ss -> ss.setService(entity))
                    .collect(Collectors.toList()));
        }
        return entity;
    }
    
    public static Service toEntity(ServiceUpdateDTO dto) {
        if (dto == null) return null;
        Service entity = new Service();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setSuggestedLaborCost(dto.getSuggestedLaborPrice());
        return entity;
    }

    public static ServiceSupply toEntity(ServiceSupplyAddDTO dto) {
        if (dto == null) return null;
        ServiceSupply entity = new ServiceSupply();
        entity.setDefaultQuantity(dto.getQuantityNeeded());
        if (dto.getSupplyId() != null) {
            entity.setSupply(new Supply(dto.getSupplyId()));
        }
        return entity;
    }

}
