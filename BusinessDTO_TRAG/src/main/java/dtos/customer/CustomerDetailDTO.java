/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.customer;

import dtos.vehicle.VehicleSummaryDTO;
import enums.CustomerStatusBusiness;
import java.util.List;

/**
 *
 * @author sonic
 */
public class CustomerDetailDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String secondLastName;
    private String phoneNumber;
    private String email;
    private CustomerStatusBusiness status;
    private List<VehicleSummaryDTO> vehicles;

    public CustomerDetailDTO() {
    }

    public CustomerDetailDTO(Long id, String firstName, String lastName, String secondLastName, String phoneNumber, String email, CustomerStatusBusiness status, List<VehicleSummaryDTO> vehicles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerStatusBusiness getStatus() {
        return status;
    }

    public void setStatus(CustomerStatusBusiness status) {
        this.status = status;
    }

    public List<VehicleSummaryDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleSummaryDTO> vehicles) {
        this.vehicles = vehicles;
    }

}
