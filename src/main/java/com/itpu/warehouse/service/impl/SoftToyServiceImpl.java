package com.itpu.warehouse.service.impl;

import java.util.List;
import com.itpu.warehouse.service.SoftToyService;
import com.itpu.warehouse.dao.SoftToyDAO;
import com.itpu.warehouse.entity.SoftToy;

/**
 * Implementation of the SoftToyService interface for accessing and manipulating
 * data of SoftToy objects in the database.
 */
public class SoftToyServiceImpl implements SoftToyService {
    private SoftToyDAO softToyDAO; // DAO for accessing and manipulating data of SoftToy objects

    /**
     * Constructor for creating a new instance of the SoftToyServiceImpl class.
     * 
     * @param softToyDAO DAO for accessing and manipulating data of SoftToy objects
     */
    public SoftToyServiceImpl(SoftToyDAO softToyDAO) {
        this.softToyDAO = softToyDAO;
    }

    /**
     * Searches for soft toys in the database based on the provided category.
     * 
     * @param category The category to search for
     * @return A list containing all soft toys stored in the database
     */
    public List<SoftToy> findByCategory(String category) {
        return softToyDAO.findByCategory(category);
    }

    /**
     * Searches for soft toys in the database based on the provided price range.
     * 
     * @param minPrice minimum price to search for.
     * @param maxPrice maximum price to search for.
     * @return A list containing all soft toys stored in the database
     */
    public List<SoftToy> findByPriceRange(double minPrice, double maxPrice) {
        return softToyDAO.findByPriceRange(minPrice, maxPrice);
    }

    /**
     * Returns a list of all soft toys stored in the database.
     * 
     * @return A list of all soft toys
     */
    public List<SoftToy> getAllToys() {
        return softToyDAO.getAllToys();
    }
}
