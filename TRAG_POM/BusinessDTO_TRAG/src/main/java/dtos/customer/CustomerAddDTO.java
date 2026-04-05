/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.customer;

import enums.CustomerStatusBusiness;

/**
 *
 * @author sonic
 */
public class CustomerAddDTO {
    private String firstName;
    private String lastName;
    private String secondLastName;
    private String phoneNumber;
    private String email;
    private CustomerStatusBusiness status;

    public CustomerAddDTO(String firstName, String lastName, String secondLastName, String phoneNumber, String email, CustomerStatusBusiness status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
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
    
    
    
}
