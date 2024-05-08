package com.itpu.warehouse.controller;

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
    public void getAllToys() {
        try {
            vehicleToyService.getAllToys().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while fetching all vehicle toys: " + e.getMessage());
        }
    }

    /**
     * Get vehicle toys by category
     * 
     * @param category The category to search for
     */
    @Override
    public void findByCategory(String category) throws ControllerException {
        try {
            vehicleToyService.findByCategory(category).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding vehicle toys by category: " + e.getMessage());
        }
    }

    /**
     * Get vehicle toys by price range
     * 
     * @param minPrice minimum price to search for.
     * @param maxPrice maximum price to search for.
     */
    @Override
    public void findByPriceRange(double minPrice, double maxPrice) {
        try {
            vehicleToyService.findByPriceRange(minPrice, maxPrice).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding vehicle toys by price range: " + e.getMessage());
        }
    }
}
