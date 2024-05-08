package com.itpu.warehouse.controller;

import com.itpu.warehouse.service.SoftToyService;

public class SoftController implements ToyController {
    private final SoftToyService softToyService;

    public SoftController(SoftToyService softToyService) {
        this.softToyService = softToyService;
    }

    /**
     * Get all soft toys
     */
    @Override
    public void getAllToys() {
        try {
            softToyService.getAllToys().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while fetching all soft toys: " + e.getMessage());
        }
    }

    /**
     * Get soft toys by category
     */
    @Override
    public void findByCategory(String category) {
        try {
            softToyService.findByCategory(category).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding soft toys by category: " + e.getMessage());
        }
    }

    /**
     * Get soft toys by price range
     */
    @Override
    public void findByPriceRange(double minPrice, double maxPrice) {
        try {
            softToyService.findByPriceRange(minPrice, maxPrice).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding soft toys by price range: " + e.getMessage());
        }
    }
}
