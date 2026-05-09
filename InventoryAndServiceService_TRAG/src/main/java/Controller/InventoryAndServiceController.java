/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exception.BusinessException;
import Service.InventoryAndServiceManager;
import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import dtos.supply.SupplySummaryDTO;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sonic
 */
@RestController
@RequestMapping("/api/catalog")
public class InventoryAndServiceController {

    private final InventoryAndServiceManager manager;

    public InventoryAndServiceController(InventoryAndServiceManager manager) {
        this.manager = manager;
    }

    /**
     * Returns the complete catalog of active services.
     * Used by the frontend to display options when creating a quote.
     */
    @GetMapping("/services")
    public ResponseEntity<?> getAllServices() {
        try {
            List<ServiceSummaryDTO> result = manager.getAllServices();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Returns the complete details of a service by its ID,
     * including the required supplies/parts.
     */
    @GetMapping("/services/{id}")
    public ResponseEntity<?> getService(@PathVariable Long id) {
        try {
            ServiceDetailDTO result = manager.getService(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Searches for services whose name partially matches the parameter.
     * Example: GET /api/catalog/services/search?name=brakes
     */
    @GetMapping("/services/search")
    public ResponseEntity<?> searchServicesByName(@RequestParam String name) {
        try {
            List<ServiceSummaryDTO> result = manager.getServicesByName(name);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * Returns the details of a supply by its ID.
     */
    @GetMapping("/supplies/{id}")
    public ResponseEntity<?> getSupply(@PathVariable Long id) {
        try {
            SupplySummaryDTO result = manager.getSupply(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Searches for supplies whose name partially matches the parameter.
     * Example: GET /api/catalog/supplies/search?name=oil
     */
    @GetMapping("/supplies/search")
    public ResponseEntity<?> searchSuppliesByName(@RequestParam String name) {
        try {
            List<SupplySummaryDTO> result = manager.getSuppliesByName(name);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
