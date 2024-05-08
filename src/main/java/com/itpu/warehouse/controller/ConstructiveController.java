package com.itpu.warehouse.controller;

import com.itpu.warehouse.service.ConstructiveToyService;

public class ConstructiveController implements ToyController {
    private final ConstructiveToyService constructiveToyService; // Service class for constructive toys

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
    public void getAllToys() {
        try {
            constructiveToyService.getAllToys().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while fetching all constructive toys: " + e.getMessage());
        }
    }

    /**
     * Get constructive toys by price range
     */
    @Override
    public void findByPriceRange(double minPrice, double maxPrice) {
        try {
            constructiveToyService.findByPriceRange(minPrice, maxPrice).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding constructive toys by price range: " + e.getMessage());
        }
    }

    /**
     * Get constructive toys by category
     */
    @Override
    public void findByCategory(String category) throws ControllerException {
        try {
            constructiveToyService.findByCategory(category).forEach(System.out::println);
        } catch (Exception e) {
            throw new ControllerException("Error while finding constructive toys by category: " + e.getMessage());
        }
    }
}
