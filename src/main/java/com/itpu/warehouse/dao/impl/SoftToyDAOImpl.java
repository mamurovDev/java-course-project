package com.itpu.warehouse.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.itpu.warehouse.dao.SoftToyDAO;
import com.itpu.warehouse.entity.SoftToy;

/**
 * Implementation of the SoftToyDAO interface for accessing and manipulating data of SoftToy objects in the database.
 */
public class SoftToyDAOImpl implements SoftToyDAO {

    private String path = "../../../../../../resources/soft.csv";

    private List<SoftToy> softToys;
    private final String DELIMITER = ",";

    /**
     * Default constructor.
     */
    public SoftToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param path The file path to load soft toy data from
     */
    public SoftToyDAOImpl(String path) {
        this.path = path;
    }

    /**
     * Retrieves all soft toys from the database.
     *
     * @return A list containing all soft toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the database
     */
    @Override
    public List<SoftToy> getAllToys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            softToys = reader.lines()
                    .skip(1)
                    .map(e -> createSoftToy(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
        return softToys;
    }

    /**
     * Creates a SoftToy object from the given values.
     *
     * @param values An array containing the attributes of the soft toy
     * @return A SoftToy object initialized with the provided attributes
     */
    private SoftToy createSoftToy(String[] values) {
        return new SoftToy.SoftToyBuilder()
                .name(values[0])
                .category(values[1])
                .price(Double.parseDouble(values[2]))
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the soft toy to delete
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void deleteToy(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the soft toy to retrieve
     * @return A SoftToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public SoftToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The soft toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(SoftToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The soft toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(SoftToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
