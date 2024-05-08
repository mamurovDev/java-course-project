package com.itpu.warehouse.service;

import com.itpu.warehouse.entity.Toy;
import java.util.List;

public interface ToyService<T extends Toy> {
    List<T> findByCategory(String category);

    List<T> findByPriceRange(double minPrice, double maxPrice);

    List<T> getAllToys();
}
