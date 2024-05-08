package com.itpu.warehouse.controller;

import com.itpu.warehouse.service.DollToyService;

public class DollController implements ToyController {
    private final DollToyService dollToyService;

    public DollController(DollToyService dollToyService) {
        this.dollToyService = dollToyService;
    }

    /**
     * Get all doll toys
     */
    public void getAllToys() {
        try {
            dollToyService.getAllToys().forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Error while fetching all doll toys: " + e.getMessage());
        }
    }

    /**
     * Get doll toys by category
     */
    public void findByCategory(String category) {
        try {
            dollToyService.findByCategory(category).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding doll toys by category: " + e.getMessage());
        }
    }

    /**
     * Get doll toys by price range
     */
    public void findByPriceRange(double minPrice, double maxPrice) {
        try {
            dollToyService.findByPriceRange(minPrice, maxPrice).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding doll toys by price range: " + e.getMessage());
        }
    }
}
