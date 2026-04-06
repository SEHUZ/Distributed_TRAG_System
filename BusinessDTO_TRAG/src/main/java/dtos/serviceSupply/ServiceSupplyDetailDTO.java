/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.serviceSupply;

import dtos.supply.SupplySummaryDTO;
import java.math.BigDecimal;

/**
 *
 * @author sonic
 */
public class ServiceSupplyDetailDTO {

    private Long id;
    private Integer quantityNeeded;
    private Long serviceId;
    private SupplySummaryDTO supply;
    private BigDecimal subtotal;

    public ServiceSupplyDetailDTO(Long id, Integer quantityNeeded, Long serviceId, SupplySummaryDTO supply) {
        this.id = id;
        this.quantityNeeded = quantityNeeded;
        this.serviceId = serviceId;
        this.supply = supply;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantityNeeded() {
        return quantityNeeded;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public SupplySummaryDTO getSupply() {
        return supply;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantityNeeded(Integer quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setSupply(SupplySummaryDTO supply) {
        this.supply = supply;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
