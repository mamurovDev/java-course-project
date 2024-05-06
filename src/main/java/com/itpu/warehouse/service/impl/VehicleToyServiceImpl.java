package com.itpu.warehouse.service.impl;

import java.util.List;
import com.itpu.warehouse.dao.VehicleToyDAO;
import com.itpu.warehouse.service.VehicleToyService;
import com.itpu.warehouse.entity.VehicleToy;

public class VehicleToyServiceImpl implements VehicleToyService {
    private VehicleToyDAO vehicleToyDAO;

    public VehicleToyServiceImpl(VehicleToyDAO vehicleToyDAO) {
        this.vehicleToyDAO = vehicleToyDAO;
    }

    @Override
    public List<VehicleToy> findByCategory(String category) {
        return vehicleToyDAO.findByCategory(category);
    }

    @Override
    public List<VehicleToy> findByPriceRange(double minPrice, double maxPrice) {
        return vehicleToyDAO.findByPriceRange(minPrice, maxPrice);
    }
}
