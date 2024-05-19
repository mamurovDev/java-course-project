package com.itpu.warehouse.controller;

import com.itpu.warehouse.service.PuzzleToyService;

import java.util.List;

import com.itpu.warehouse.entity.PuzzleToy;

public class PuzzleController implements ToyController {
    private final PuzzleToyService puzzleToyService;

    public PuzzleController(PuzzleToyService puzzleToyService) {
        this.puzzleToyService = puzzleToyService;
    }

    /**
     * Get all puzzle toys
     */
    @Override
    public List<PuzzleToy> getAllToys() {
        try {
            return puzzleToyService.getAllToys();
        } catch (Exception e) {
            System.out.println("Error while fetching all vehicle toys: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get puzzle toys by category
     */
    @Override
    public List<PuzzleToy> findByCategory(String category) {
        try {
            return puzzleToyService.findByCategory(category);
        } catch (Exception e) {
            System.out.println("Error while finding puzzle toys by category: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Get puzzle toys by price range
     */
    @Override
    public List<PuzzleToy> findByPriceRange(double minPrice, double maxPrice) {
        try {
            return puzzleToyService.findByPriceRange(minPrice, maxPrice);
        } catch (Exception e) {
            System.out.println("Error while finding puzzle toys by price range: " + e.getMessage());
            return List.of();
        }
    }

}
