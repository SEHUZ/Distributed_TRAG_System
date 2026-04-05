/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sonic
 */
@Entity
@Table(name = "services")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal suggestedLaborCost;
    
    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(nullable = true, length = 255)
    private String iconRoute;
    
    @OneToMany (mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServiceSupply> serviceSupplies;

    public Service() {
    }

    public Service(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getSuggestedLaborCost() {
        return suggestedLaborCost;
    }

    public void setSuggestedLaborCost(BigDecimal suggestedLaborCost) {
        this.suggestedLaborCost = suggestedLaborCost;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getIconRoute() {
        return iconRoute;
    }

    public void setIconRoute(String iconRoute) {
        this.iconRoute = iconRoute;
    }

    public List<ServiceSupply> getServiceSupplies() {
        return serviceSupplies;
    }

    public void setServiceSupplies(List<ServiceSupply> serviceSupplies) {
        this.serviceSupplies = serviceSupplies;
    }   

    
}
