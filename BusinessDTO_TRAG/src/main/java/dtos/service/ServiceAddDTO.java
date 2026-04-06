/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.service;

import dtos.serviceSupply.ServiceSupplyAddDTO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author sonic
 */
public class ServiceAddDTO {

    private String name;
    private String description;
    private BigDecimal suggestedLaborPrice;
    private String iconPath;
    private List<ServiceSupplyAddDTO> serviceSupplies;

    public ServiceAddDTO(String name, String description, BigDecimal suggestedLaborPrice, String iconPath, List<ServiceSupplyAddDTO> serviceSupplies) {
        this.name = name;
        this.description = description;
        this.suggestedLaborPrice = suggestedLaborPrice;
        this.iconPath = iconPath;
        this.serviceSupplies = serviceSupplies;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getSuggestedLaborPrice() {
        return suggestedLaborPrice;
    }

    public String getIconPath() {
        return iconPath;
    }

    public List<ServiceSupplyAddDTO> getServiceSupplies() {
        return serviceSupplies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSuggestedLaborPrice(BigDecimal suggestedLaborPrice) {
        this.suggestedLaborPrice = suggestedLaborPrice;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setServiceSupplies(List<ServiceSupplyAddDTO> serviceSupplies) {
        this.serviceSupplies = serviceSupplies;
    }
}
