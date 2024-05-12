package com.itpu.warehouse.controller;

import java.util.List;

import com.itpu.warehouse.entity.ConstructiveToy;

import com.itpu.warehouse.service.ConstructiveToyService;

public class ConstructiveController implements ToyController {
    private  ConstructiveToyService constructiveToyService; // Service class for constructive toys

    /**
     * Constructor for the class
     * 
     * @param constructiveToyService
     */
    public ConstructiveController(ConstructiveToyService constructiveToyService) {
        this.constructiveToyService = constructiveToyService; // Initialize the service
    }

    /**
     * Get all constructive toys
     */
    @Override
    public List<ConstructiveToy> getAllToys() {
        try {
            return constructiveToyService.getAllToys();
        } catch (Exception e) {
            System.out.println("Error while fetching all vehicle toys: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get constructive toys by category
     */
    @Override
    public List<ConstructiveToy> findByCategory(String category) {
        try {
            return constructiveToyService.findByCategory(category);
        } catch (Exception e) {
            System.out.println("Error while finding constructive toys by category: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get constructive toys by price range
     */
    public List<ConstructiveToy> findByPriceRange(double minPrice, double maxPrice) {
        try {
            return constructiveToyService.findByPriceRange(minPrice, maxPrice);
        } catch (Exception e) {
            System.out.println("Error while finding constructive toys by price range: " + e.getMessage());
            return List.of();
        }
    }

}
