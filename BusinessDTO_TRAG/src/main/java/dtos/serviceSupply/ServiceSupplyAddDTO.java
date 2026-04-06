/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.serviceSupply;

/**
 *
 * @author sonic
 */
public class ServiceSupplyAddDTO {

    private Integer quantityNeeded;
    private Long serviceId;
    private Long supplyId;

    public ServiceSupplyAddDTO(Integer quantityNeeded, Long serviceId, Long supplyId) {
        this.quantityNeeded = quantityNeeded;
        this.serviceId = serviceId;
        this.supplyId = supplyId;
    }

    public Integer getQuantityNeeded() {
        return quantityNeeded;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setQuantityNeeded(Integer quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }
}
