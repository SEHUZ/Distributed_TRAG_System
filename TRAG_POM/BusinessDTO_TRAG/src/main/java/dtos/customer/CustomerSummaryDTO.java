/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.customer;

/**
 *
 * @author sonic
 */
public class CustomerSummaryDTO {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String secondLastName;

    public CustomerSummaryDTO(Long id, String firstName, String lastName, String secondLastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
    }

    public CustomerSummaryDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + (secondLastName != null ? secondLastName : "");
    }
    
    
}
