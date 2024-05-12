package com.itpu.warehouse.controller;

import java.util.List;

import com.itpu.warehouse.entity.DollToy;
import com.itpu.warehouse.entity.VehicleToy;
import com.itpu.warehouse.service.DollToyService;

public class DollController implements ToyController {
    private final DollToyService dollToyService;

    public DollController(DollToyService dollToyService) {
        this.dollToyService = dollToyService;
    }

    /**
     * Get all doll toys
     */
    @Override
    public List<DollToy> getAllToys() {
        try {
            return dollToyService.getAllToys();
        } catch (Exception e) {
            System.out.println("Error while fetching all vehicle toys: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get doll toys by category
     */
    public List<DollToy> findByCategory(String category) {
        try {
            return dollToyService.findByCategory(category);
        } catch (Exception e) {
            System.out.println("Error while finding doll toys by category: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get doll toys by price range
     */
    public List<DollToy> findByPriceRange(double minPrice, double maxPrice) {
        try {
            return dollToyService.findByPriceRange(minPrice, maxPrice);
        } catch (Exception e) {
            System.out.println("Error while finding doll toys by price range: " + e.getMessage());
            return List.of();
        }
    }
}
