/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.quote;

import dtos.quoteSupply.QuoteSupplyAddDTO;
import enums.QuoteStatusBusiness;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sonic
 */
public class QuoteAddDTO {

    private BigDecimal laborPrice;
    private String vehicleStatus;
    private String generalDiagnosis;
    private LocalDateTime createdAt;
    private List<QuoteSupplyAddDTO> quoteSupplies;

    private Long serviceId;
    private Long customerId;
    private Long vehicleId;

    private QuoteStatusBusiness status;

    public QuoteAddDTO(BigDecimal laborPrice, String vehicleStatus, String generalDiagnosis, LocalDateTime createdAt, List<QuoteSupplyAddDTO> quoteSupplies, Long serviceId, Long customerId, Long vehicleId) {
        this.laborPrice = laborPrice;
        this.vehicleStatus = vehicleStatus;
        this.generalDiagnosis = generalDiagnosis;
        this.createdAt = createdAt;
        this.quoteSupplies = quoteSupplies;
        this.serviceId = serviceId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
    }

    public BigDecimal getLaborPrice() {
        return laborPrice;
    }

    public void setLaborPrice(BigDecimal laborPrice) {
        this.laborPrice = laborPrice;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getGeneralDiagnosis() {
        return generalDiagnosis;
    }

    public void setGeneralDiagnosis(String generalDiagnosis) {
        this.generalDiagnosis = generalDiagnosis;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<QuoteSupplyAddDTO> getQuoteSupplies() {
        return quoteSupplies;
    }

    public void setQuoteSupplies(List<QuoteSupplyAddDTO> quoteSupplies) {
        this.quoteSupplies = quoteSupplies;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public QuoteStatusBusiness getStatus() {
        return status;
    }

    public void setStatus(QuoteStatusBusiness status) {
        this.status = status;
    }
}
