package com.itpu.warehouse.service.impl;

import java.util.List;

import com.itpu.warehouse.dao.ConstructiveToyDAO;
import com.itpu.warehouse.service.ConstructiveToyService;
import com.itpu.warehouse.entity.ConstructiveToy;

/**
 * ConstructiveToyServiceImpl
 */
public class ConstructiveToyServiceImpl implements ConstructiveToyService {
    private ConstructiveToyDAO constructiveToyDAO; // DAO for accessing and manipulating data of SoftToy objects

    /**
     * Constructor for creating a new instance of the SoftToyServiceImpl class.
     * 
     * @param constructiveToyDAO DAO for accessing and manipulating data of SoftToy
     *                           objects
     */
    public ConstructiveToyServiceImpl(ConstructiveToyDAO constructiveToyDAO) {
        this.constructiveToyDAO = constructiveToyDAO;
    }

    /**
     * Searches for soft toys in the database based on the provided category.
     * 
     * @param category The category to search for
     * @return A list containing all soft toys stored in the database
     */
    public List<ConstructiveToy> findByCategory(String category) {
        return constructiveToyDAO.findByCategory(category);
    }

    /**
     * Searches for soft toys in the database based on the provided price range.
     * 
     * @param minPrice minimum price to search for.
     * @param maxPrice maximum price to search for.
     * @return A list containing all soft toys stored in the database
     */
    public List<ConstructiveToy> findByPriceRange(double minPrice, double maxPrice) {
        return constructiveToyDAO.findByPriceRange(minPrice, maxPrice);
    }

    /**
     * Returns a list of all soft toys stored in the database.
     */
    public List<ConstructiveToy> getAllToys() {
        return constructiveToyDAO.getAllToys();
    }
}