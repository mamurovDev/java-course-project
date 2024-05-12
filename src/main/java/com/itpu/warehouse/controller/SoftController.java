package com.itpu.warehouse.controller;

import java.util.List;

import com.itpu.warehouse.service.SoftToyService;
import com.itpu.warehouse.entity.SoftToy;
import com.itpu.warehouse.entity.VehicleToy;

public class SoftController implements ToyController {
    private final SoftToyService softToyService;

    public SoftController(SoftToyService softToyService) {
        this.softToyService = softToyService;
    }

    /**
     * Get all soft toys
     */
    @Override
    public List<SoftToy> getAllToys() {
        try {
            return softToyService.getAllToys();
        } catch (Exception e) {
            System.out.println("Error while fetching all vehicle toys: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get soft toys by category
     */
    @Override
    public List<SoftToy> findByCategory(String category) {
        try {
            return softToyService.findByCategory(category);
        } catch (Exception e) {
            System.out.println("Error while finding soft toys by category: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get soft toys by price range
     */

    public List<SoftToy> findByPriceRange(double minPrice, double maxPrice) {
        try {
            return softToyService.findByPriceRange(minPrice, maxPrice);
        } catch (Exception e) {
            System.out.println("Error while finding soft toys by price range: " + e.getMessage());
            return List.of();
        }
    }
}
