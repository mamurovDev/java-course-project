package com.itpu.warehouse.service.impl;

import java.util.List;
import com.itpu.warehouse.dao.VehicleToyDAO;
import com.itpu.warehouse.service.VehicleToyService;
import com.itpu.warehouse.entity.VehicleToy;

/**
 * Implementation of the VehicleToyService interface for accessing and
 * manipulating
 * data of VehicleToy objects in the database.
 */
public class VehicleToyServiceImpl implements VehicleToyService {
    private VehicleToyDAO vehicleToyDAO; //

    /**
     * Constructor for VehicleToyServiceImpl.
     * 
     * @param vehicleToyDAO
     */
    public VehicleToyServiceImpl(VehicleToyDAO vehicleToyDAO) {
        this.vehicleToyDAO = vehicleToyDAO;
    }

    /**
     * Searches for vehicle toys in the database based on the provided category.
     * 
     * @param category The category to search for
     * @return A list containing all vehicle toys stored in the database
     */
    @Override
    public List<VehicleToy> findByCategory(String category) {
        return vehicleToyDAO.findByCategory(category);
    }

    /**
     * Searches for vehicle toys in the database based on the provided price range.
     * 
     * @param minPrice minimum price to search for.
     * @param maxPrice maximum price to search for.
     * @return A list containing all vehicle toys stored in the database
     */
    @Override
    public List<VehicleToy> findByPriceRange(double minPrice, double maxPrice) {
        return vehicleToyDAO.findByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<VehicleToy> getAllToys() {
        return vehicleToyDAO.getAllToys();
    }
}
