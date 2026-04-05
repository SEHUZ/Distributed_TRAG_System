/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.quote;

import dtos.quoteSupply.QuoteSupplyDetailDTO;
import enums.QuoteStatusBusiness;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sonic
 */
public class QuoteSummaryDTO {

    private Long id;

    private String customerFirstName;
    private String customerLastName;
    private String customerSecondLastName;

    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleLicensePlate;
    private Integer vehicleYear;

    private LocalDateTime createdAt;
    private BigDecimal laborPrice;
    private List<QuoteSupplyDetailDTO> quoteSupplies;
    private BigDecimal totalPrice;
    private QuoteStatusBusiness status;

    public QuoteSummaryDTO(Long id, String customerFirstName, String customerLastName, String customerSecondLastName, String vehicleBrand, String vehicleModel, String vehicleLicensePlate, Integer vehicleYear, LocalDateTime createdAt, BigDecimal laborPrice, List<QuoteSupplyDetailDTO> quoteSupplies, QuoteStatusBusiness status) {
        this.id = id;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerSecondLastName = customerSecondLastName;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.vehicleYear = vehicleYear;
        this.createdAt = createdAt;
        this.laborPrice = laborPrice;
        this.quoteSupplies = quoteSupplies;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerSecondLastName() {
        return customerSecondLastName;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getLaborPrice() {
        return laborPrice;
    }

    public List<QuoteSupplyDetailDTO> getQuoteSupplies() {
        return quoteSupplies;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public QuoteStatusBusiness getStatus() {
        return status;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
