package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.DollToyDAO;
import com.itpu.warehouse.entity.DollToy;
import com.itpu.warehouse.enums.Gender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementation of the DollToyDAO interface for accessing and manipulating
 * data of DollToy objects in the database.
 */
public class DollToyDAOImpl implements DollToyDAO {
    private final String DELIMITER = ","; // Adjust the delimiter as needed
    String filePath = "src/main/resources/doll_toys.csv"; // Adjust the file path with correct extension

    /**
     * Default constructor.
     */
    public DollToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param filePath The file path to load doll toy data from
     */
    public DollToyDAOImpl(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Retrieves all doll toys from the database.
     *
     * @return A list containing all doll toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the
     *                          database
     */
    @Override
    public List<DollToy> getAllToys() {
        List<DollToy> dollToys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // Skip the header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                DollToy dollToy = createDollToy(row);
                dollToys.add(dollToy);
            }

            return dollToys;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    /**
     * Creates a DollToy object from the given values.
     *
     * @param values An array containing the attributes of the doll toy
     * @return A DollToy object initialized with the provided attributes
     */
    private DollToy createDollToy(String[] values) {
        String id = values[0]; // Use the first value as the ID
        String name = values[1]; // Use the second value as the name
        String category = values[2]; // Use the third value as the category
        double price = Double.parseDouble(values[3]); // Use the fourth value as the price
        int recommendedAge = Integer.parseInt(values[4]); // Use the fifth value as the recommended age
        Gender gender = Gender.fromString(values[5]);

        return new DollToy.DollToyBuilder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .recommendedAge(recommendedAge)
                .gender(gender)
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param id The ID of the doll toy to delete
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void deleteToy(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
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
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The doll toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(DollToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The doll toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(DollToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
