/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.vehicle;

/**
 *
 * @author sonic
 */
public class VehicleUpdateDTO {

    private final Long id;
    private final Integer year;
    private final String licensePlate;
    private final String vin;
    private final String model;
    private final String brand;
    private final Long customerId;

    public VehicleUpdateDTO(Long id, Integer year, String licensePlate, String vin, String model, String brand, Long customerId) {
        this.id = id;
        this.year = year;
        this.licensePlate = licensePlate;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Long getCustomerId() {
        return customerId;
    }

}
