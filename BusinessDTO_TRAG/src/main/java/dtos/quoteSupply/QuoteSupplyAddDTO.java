/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.quoteSupply;

import java.math.BigDecimal;

/**
 *
 * @author sonic
 */
public class QuoteSupplyAddDTO {

    private Integer quantityRequired;
    private BigDecimal price;
    private Long supplyId;

    public QuoteSupplyAddDTO(Integer quantityRequired, BigDecimal price, Long supplyId) {
        this.quantityRequired = quantityRequired;
        this.price = price;
        this.supplyId = supplyId;
    }

    public Integer getQuantityRequired() {
        return quantityRequired;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setQuantityRequired(Integer quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }
}
