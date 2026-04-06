/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.service;

import java.math.BigDecimal;

/**
 *
 * @author sonic
 */
public class ServiceUpdateDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal suggestedLaborPrice;

    public ServiceUpdateDTO() {
    }

    public ServiceUpdateDTO(Long id, String name, String description, BigDecimal suggestedLaborPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.suggestedLaborPrice = suggestedLaborPrice;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
}
