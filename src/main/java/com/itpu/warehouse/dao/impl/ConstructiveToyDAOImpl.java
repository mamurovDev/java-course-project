package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.ConstructiveToyDAO;
import com.itpu.warehouse.entity.ConstructiveToy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the ConstructiveToyDAO interface for accessing and manipulating data of ConstructiveToy objects in the database.
 */
public class ConstructiveToyDAOImpl implements ConstructiveToyDAO {
    private String path = "../../../../../../resources/constructive.csv";

    private List<ConstructiveToy> constructiveToys;
    private final String DELIMITER = ",";

    /**
     * Default constructor.
     */
    public ConstructiveToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param path The file path to load constructive toy data from
     */
    public ConstructiveToyDAOImpl(String path) {
        this.path = path;
    }

    /**
     * Retrieves all constructive toys from the database.
     *
     * @return A list containing all constructive toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the database
     */
    @Override
    public List<ConstructiveToy> getAllToys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            constructiveToys = reader.lines()
                    .skip(1)
                    .map(e -> createConstructiveToy(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("File not found", e);
        }
        return constructiveToys;
    }

    /**
     * Creates a ConstructiveToy object from the given values.
     *
     * @param values An array containing the attributes of the constructive toy
     * @return A ConstructiveToy object initialized with the provided attributes
     */
    private ConstructiveToy createConstructiveToy(String[] values) {
        return new ConstructiveToy.ConstructiveToyBuilder()
                .name(values[0])
                .category(values[1])
                .price(Double.parseDouble(values[2]))
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the constructive toy to delete
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void deleteToy(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the constructive toy to retrieve
     * @return A ConstructiveToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public ConstructiveToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The constructive toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(ConstructiveToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The constructive toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(ConstructiveToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
