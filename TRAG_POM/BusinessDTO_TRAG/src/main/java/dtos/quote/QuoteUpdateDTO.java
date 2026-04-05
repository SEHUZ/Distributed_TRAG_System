/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.quote;

import dtos.quoteSupply.QuoteSupplyUpdateDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sonic
 */
public class QuoteUpdateDTO {

    private Long id;
    private BigDecimal laborPrice;
    private String vehicleStatus;
    private String generalDiagnosis;
    private LocalDateTime createdAt;
    private List<QuoteSupplyUpdateDTO> quoteSupplies;

    public QuoteUpdateDTO(Long id, BigDecimal laborPrice, String vehicleStatus, String generalDiagnosis, List<QuoteSupplyUpdateDTO> quoteSupplies) {
        this.id = id;
        this.laborPrice = laborPrice;
        this.vehicleStatus = vehicleStatus;
        this.generalDiagnosis = generalDiagnosis;
        this.quoteSupplies = quoteSupplies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<QuoteSupplyUpdateDTO> getQuoteSupplies() {
        return quoteSupplies;
    }

    public void setQuoteSupplies(List<QuoteSupplyUpdateDTO> quoteSupplies) {
        this.quoteSupplies = quoteSupplies;
    }
}
