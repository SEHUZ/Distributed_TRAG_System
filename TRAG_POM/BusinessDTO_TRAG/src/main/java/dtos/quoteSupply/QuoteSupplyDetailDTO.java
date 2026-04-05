/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.quoteSupply;

import dtos.supply.SupplySummaryDTO;
import java.math.BigDecimal;

/**
 *
 * @author sonic
 */
public class QuoteSupplyDetailDTO {

    private Long id;
    private Integer quantityRequired;
    private BigDecimal price;
    private Long quoteId;
    private SupplySummaryDTO supply;
    private BigDecimal subtotal;
    private boolean active;

    public QuoteSupplyDetailDTO(Long id, Integer quantityRequired, BigDecimal price, Long quoteId, SupplySummaryDTO supply, boolean active) {
        this.id = id;
        this.quantityRequired = quantityRequired;
        this.price = price;
        this.quoteId = quoteId;
        this.supply = supply;
        this.active = active;
    }

    public QuoteSupplyDetailDTO(Long id, Integer quantityRequired, BigDecimal price) {
        this.id = id;
        this.quantityRequired = quantityRequired;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantityRequired() {
        return quantityRequired;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public SupplySummaryDTO getSupply() {
        return supply;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantityRequired(Integer quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public void setSupply(SupplySummaryDTO supply) {
        this.supply = supply;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
