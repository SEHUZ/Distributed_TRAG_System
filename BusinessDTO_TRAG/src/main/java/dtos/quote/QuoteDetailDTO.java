/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.quote;

import dtos.customer.CustomerSummaryDTO;
import dtos.quoteSupply.QuoteSupplyDetailDTO;
import dtos.vehicle.VehicleSummaryDTO;
import enums.QuoteStatusBusiness;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sonic
 */
public class QuoteDetailDTO {

    private Long id;
    private BigDecimal laborPrice;
    private String vehicleStatus;
    private String generalDiagnosis;
    private LocalDateTime createdAt;
    private LocalDateTime creationDate;
    private String diagnostic;
    private String vehicleState;
    private List<QuoteSupplyDetailDTO> quoteSupplies;

    private String serviceName;
    private CustomerSummaryDTO customer;
    private VehicleSummaryDTO vehicle;

    private QuoteStatusBusiness status;

    public QuoteDetailDTO() {
    }

    public QuoteDetailDTO(Long id, BigDecimal laborPrice, String vehicleStatus, String generalDiagnosis, LocalDateTime createdAt, List<QuoteSupplyDetailDTO> quoteSupplies, String serviceName, CustomerSummaryDTO customer, VehicleSummaryDTO vehicle, QuoteStatusBusiness status) {
        this.id = id;
        this.laborPrice = laborPrice;
        this.vehicleStatus = vehicleStatus;
        this.generalDiagnosis = generalDiagnosis;
        this.createdAt = createdAt;
        this.quoteSupplies = quoteSupplies;
        this.serviceName = serviceName;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getLaborPrice() {
        return laborPrice;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public String getGeneralDiagnosis() {
        return generalDiagnosis;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<QuoteSupplyDetailDTO> getQuoteSupplies() {
        return quoteSupplies;
    }

    public String getServiceName() {
        return serviceName;
    }

    public CustomerSummaryDTO getCustomer() {
        return customer;
    }

    public VehicleSummaryDTO getVehicle() {
        return vehicle;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }

    public QuoteStatusBusiness getStatus() {
        return status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setCustomer(CustomerSummaryDTO customer) {
        this.customer = customer;
    }

    public void setVehicle(VehicleSummaryDTO vehicle) {
        this.vehicle = vehicle;
    }

    public void setQuoteSupplies(List<QuoteSupplyDetailDTO> quoteSupplies) {
        this.quoteSupplies = quoteSupplies;
    }

    public void setLaborPrice(BigDecimal laborPrice) {
        this.laborPrice = laborPrice;
    }
}
