package com.itpu.warehouse.dao;

import com.itpu.warehouse.entity.Toy;

import java.util.List;

/**
 * Interface for accessing and manipulating data of toys in the database.
 *
 * @param <T> The type of toy entity
 */
public interface ToyDAO<T extends Toy> {
    // Method to retrieve all toys
    List<T> getAllToys();

    // Method to retrieve a toy by its ID
    T getToyById(String id);

    // Method to save a new toy
    void saveToy(T toy);

    // Method to update an existing toy
    void updateToy(T toy);

    // Method to delete a toy by its ID
    void deleteToy(String id);

    List<T> findByCategory(String category);

    List<T> findByPriceRange(double minPrice, double maxPrice);

}
