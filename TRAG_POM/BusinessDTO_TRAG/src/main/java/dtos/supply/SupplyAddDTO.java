/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.supply;

import java.math.BigDecimal;

/**
 *
 * @author sonic
 */
public class SupplyAddDTO {

    private String name;
    private BigDecimal suggestedPrice;
    private Long supplierId;

    public SupplyAddDTO(String name, BigDecimal suggestedPrice, Long supplierId) {
        this.name = name;
        this.suggestedPrice = suggestedPrice;
        this.supplierId = supplierId;
    }

    public SupplyAddDTO(String name, BigDecimal suggestedPrice) {
        this.name = name;
        this.suggestedPrice = suggestedPrice;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSuggestedPrice() {
        return suggestedPrice;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuggestedPrice(BigDecimal suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
