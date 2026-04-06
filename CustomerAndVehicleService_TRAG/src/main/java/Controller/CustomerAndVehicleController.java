/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exception.BusinessException;
import Service.CustomerAndVehicleManager;
import dtos.customer.CustomerAddDTO;
import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import dtos.customer.CustomerUpdateDTO;
import dtos.vehicle.VehicleAddDTO;
import dtos.vehicle.VehicleDetailDTO;
import dtos.vehicle.VehicleSummaryDTO;
import dtos.vehicle.VehicleUpdateDTO;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sonic
 */
@RestController
@RequestMapping("/api")
public class CustomerAndVehicleController{

    private final CustomerAndVehicleManager manager;

    public CustomerAndVehicleController(CustomerAndVehicleManager manager) {
        this.manager = manager;
    }

    // CUSTOMER ENDPOINTS
    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerAddDTO dto) {
        try {
            CustomerDetailDTO result = manager.createCustomer(dto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        try {
            CustomerDetailDTO result = manager.getCustomer(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        try {
            List<CustomerSummaryDTO> result = manager.getAllCustomers();
            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @PutMapping("/customers")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerUpdateDTO dto) {
        try {
            CustomerDetailDTO result = manager.updateCustomer(dto);
            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // 400
        }
    }

    // VEHICLE ENDPOINTS
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleAddDTO dto) {
        try {
            VehicleDetailDTO result = manager.addVehicle(dto);
            return new ResponseEntity<>(result, HttpStatus.CREATED); // 201
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // 400
        }
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable Long id) {
        try {
            VehicleDetailDTO result = manager.getVehicle(id);
            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404
        }
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getAllVehicles() {
        try {
            List<VehicleSummaryDTO> result = manager.getAllVehicles();
            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }
}
