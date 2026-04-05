/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.vehicle;

/**
 *
 * @author sonic
 */
public class VehicleAddDTO {
    
    private Integer year;
    private String licensePlate;
    private String vin;
    private String model;
    private String brand;
    private Long customerId;

    public VehicleAddDTO(Integer year, String licensePlate, String vin, String model, String brand, Long customerId) {
        this.year = year;
        this.licensePlate = licensePlate;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.customerId = customerId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    
    
}
