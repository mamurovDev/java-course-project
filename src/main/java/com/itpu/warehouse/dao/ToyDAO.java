package com.itpu.warehouse.dao;

import com.itpu.warehouse.entity.Toy;

import java.util.List;

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
}
