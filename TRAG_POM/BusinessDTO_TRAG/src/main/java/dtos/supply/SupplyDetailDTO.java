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
public class SupplyDetailDTO {

    private Long id;
    private String name;
    private BigDecimal suggestedPrice;
    private Long supplierId;

    public SupplyDetailDTO(Long id, String name, BigDecimal suggestedPrice, Long supplierId) {
        this.id = id;
        this.name = name;
        this.suggestedPrice = suggestedPrice;
        this.supplierId = supplierId;
    }

    public SupplyDetailDTO(Long id, String name, BigDecimal suggestedPrice) {
        this.id = id;
        this.name = name;
        this.suggestedPrice = suggestedPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(BigDecimal suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
