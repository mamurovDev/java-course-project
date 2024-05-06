package com.itpu.warehouse.service.impl;

import java.util.List;

import com.itpu.warehouse.dao.PuzzleToyDAO;
import com.itpu.warehouse.entity.PuzzleToy;

public class PuzzleToyServiceImpl {
    private PuzzleToyDAO puzzleToyDAO; // DAO for accessing and manipulating data of SoftToy objects

    /**
     * Constructor for creating a new instance of the SoftToyServiceImpl class.
     * 
     * @param puzzleToyDAO DAO for accessing and manipulating data of SoftToy
     *                     objects
     */
    public PuzzleToyServiceImpl(PuzzleToyDAO puzzleToyDAO) {
        this.puzzleToyDAO = puzzleToyDAO;
    }

    /**
     * Searches for soft toys in the database based on the provided category.
     * 
     * @param category The category to search for
     * @return A list containing all soft toys stored in the database
     */
    public List<PuzzleToy> findByCategory(String category) {
        return puzzleToyDAO.findByCategory(category);
    }

    /**
     * Searches for soft toys in the database based on the provided price range.
     * 
     * @param minPrice minimum price to search for.
     * @param maxPrice maximum price to search for.
     * @return A list containing all soft toys stored in the database
     */
    public List<PuzzleToy> findByPriceRange(double minPrice, double maxPrice) {
        return puzzleToyDAO.findByPriceRange(minPrice, maxPrice);
    }
}
