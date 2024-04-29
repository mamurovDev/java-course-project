package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.DollToyDAO;
import com.itpu.warehouse.entity.DollToy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the DollToyDAO interface for accessing and manipulating data of DollToy objects in the database.
 */
public class DollToyDAOImpl implements DollToyDAO {
    private String path = "../../../../../../resources/doll.csv";

    private List<DollToy> dollToys;
    private final String DELIMITER = ",";

    /**
     * Default constructor.
     */
    public DollToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param path The file path to load doll toy data from
     */
    public DollToyDAOImpl(String path) {
        this.path = path;
    }

    /**
     * Retrieves all doll toys from the database.
     *
     * @return A list containing all doll toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the database
     */
    @Override
    public List<DollToy> getAllToys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            dollToys = reader.lines()
                    .skip(1)
                    .map(e -> createDollToy(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
        return dollToys;
    }

    /**
     * Creates a DollToy object from the given values.
     *
     * @param values An array containing the attributes of the doll toy
     * @return A DollToy object initialized with the provided attributes
     */
    private DollToy createDollToy(String[] values) {
        return new DollToy.DollToyBuilder()
                .name(values[0])
                .category(values[1])
                .price(Double.parseDouble(values[2]))
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the doll toy to delete
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void deleteToy(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the doll toy to retrieve
     * @return A DollToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public DollToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The doll toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(DollToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The doll toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(DollToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
