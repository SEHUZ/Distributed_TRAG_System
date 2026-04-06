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
public class QuoteSupplyUpdateDTO {

    private Integer quantityRequired;
    private BigDecimal price;
    private Long quoteId;
    private Long supplyId;

    public QuoteSupplyUpdateDTO(Integer quantityRequired, BigDecimal price, Long quoteId, Long supplyId) {
        this.quantityRequired = quantityRequired;
        this.price = price;
        this.quoteId = quoteId;
        this.supplyId = supplyId;
    }

    public Integer getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(Integer quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }
}
