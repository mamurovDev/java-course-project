package com.itpu.warehouse.controller;

public interface ToyController {
    void getAllToys() throws ControllerException;

    void findByCategory(String category) throws ControllerException;

    void findByPriceRange(double minPrice, double maxPrice) throws ControllerException;
}
