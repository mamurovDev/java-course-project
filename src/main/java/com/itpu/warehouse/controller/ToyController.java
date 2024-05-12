package com.itpu.warehouse.controller;

import java.util.List;

import com.itpu.warehouse.entity.Toy;

public interface ToyController {
    List<? extends Toy> getAllToys() throws ControllerException;

    List<? extends Toy> findByCategory(String category) throws ControllerException;

    List<? extends Toy> findByPriceRange(double minPrice, double maxPrice) throws ControllerException;
}
