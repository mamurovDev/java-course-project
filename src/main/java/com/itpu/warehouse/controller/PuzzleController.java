package com.itpu.warehouse.controller;

import com.itpu.warehouse.service.PuzzleToyService;

public class PuzzleController implements ToyController {
    private final PuzzleToyService puzzleToyService;

    public PuzzleController(PuzzleToyService puzzleToyService) {
        this.puzzleToyService = puzzleToyService;
    }

    /**
     * Get all puzzle toys
     */
    @Override
    public void getAllToys() {
        try {
            puzzleToyService.getAllToys().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while fetching all puzzle toys: " + e.getMessage());
        }
    }

    /**
     * Get puzzle toys by category
     */
    @Override
    public void findByCategory(String category) {
        try {
            puzzleToyService.findByCategory(category).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding puzzle toys by category: " + e.getMessage());
        }
    }

    /**
     * Get puzzle toys by price range
     */
    @Override
    public void findByPriceRange(double minPrice, double maxPrice) {
        try {
            puzzleToyService.findByPriceRange(minPrice, maxPrice).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error while finding puzzle toys by price range: " + e.getMessage());
        }
    }

}
