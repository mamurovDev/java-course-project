package com.itpu.warehouse.service.impl;

import java.util.List;

import com.itpu.warehouse.dao.DollToyDAO;
import com.itpu.warehouse.entity.DollToy;
import com.itpu.warehouse.service.DollToyService;

public class DollToyServiceImpl implements DollToyService {
    private DollToyDAO dollToyDAO; // DAO for accessing and manipulating data of SoftToy objects

    /**
     * Constructor for creating a new instance of the SoftToyServiceImpl class.
     * 
     * @param dollToyDAO DAO for accessing and manipulating data of SoftToy
     *                   objects
     */
    public DollToyServiceImpl(DollToyDAO dollToyDAO) {
        this.dollToyDAO = dollToyDAO;
    }

    /**
     * Searches for soft toys in the database based on the provided category.
     * 
     * @param category The category to search for
     * @return A list containing all soft toys stored in the database
     */
    public List<DollToy> findByCategory(String category) {
        return dollToyDAO.findByCategory(category);
    }

    /**
     * Searches for soft toys in the database based on the provided price range.
     * 
     * @param minPrice minimum price to search for.
     * @param maxPrice maximum price to search for.
     * @return A list containing all soft toys stored in the database
     */
    public List<DollToy> findByPriceRange(double minPrice, double maxPrice) {
        return dollToyDAO.findByPriceRange(minPrice, maxPrice);
    }

    /**
     * Returns a list of all soft toys stored in the database.
     * 
     * @return A list of all soft toys
     */
    public List<DollToy> getAllToys() {
        return dollToyDAO.getAllToys();
    }

    /**
     * Returns a list of all soft toys stored in the database.
     */
    public List<DollToy> getDollToys() {
        return dollToyDAO.getAllToys();
    }
}
