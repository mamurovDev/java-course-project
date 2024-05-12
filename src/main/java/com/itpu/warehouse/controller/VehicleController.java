package com.itpu.warehouse.controller;

import java.util.List;

import com.itpu.warehouse.entity.Toy;
import com.itpu.warehouse.entity.VehicleToy;
import com.itpu.warehouse.service.VehicleToyService;

public class VehicleController implements ToyController {

    private VehicleToyService vehicleToyService;

    public VehicleController(VehicleToyService vehicleToyService) {
        this.vehicleToyService = vehicleToyService;
    }

    /**
     * Get all vehicle toys
     */
    @Override
    public List<VehicleToy> getAllToys() {
        try {
            return vehicleToyService.getAllToys();
        } catch (Exception e) {
            System.out.println("Error while fetching all vehicle toys: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get vehicle toys by category
     * 
     * @param category The category to search for
     */
    @Override
    public List<VehicleToy> findByCategory(String category) {
        try {
            return vehicleToyService.findByCategory(category);
        } catch (Exception e) {
            System.out.println("Error while finding vehicle toys by category: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get vehicle toys by price range
     * 
     * @param minPrice minimum price to search for.
     * @param maxPrice maximum price to search for.
     */
    @Override
    public List<VehicleToy> findByPriceRange(double minPrice, double maxPrice) {
        try {
            return vehicleToyService.findByPriceRange(minPrice, maxPrice);
        } catch (Exception e) {
            System.out.println("Error while finding vehicle toys by price range: " + e.getMessage());
            return List.of();
        }
    }
}
