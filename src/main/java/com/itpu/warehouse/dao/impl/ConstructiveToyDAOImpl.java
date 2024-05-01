package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.ConstructiveToyDAO;
import com.itpu.warehouse.entity.ConstructiveToy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementation of the ConstructiveToyDAO interface for accessing and
 * manipulating data of ConstructiveToy objects in the database.
 */
public class ConstructiveToyDAOImpl implements ConstructiveToyDAO {
    private final String DELIMITER = ","; // Adjust the delimiter as needed
    String filePath = "src/main/resources/constructive_toys.csv"; // Adjust the file path with correct extension

    /**
     * Default constructor.
     */
    public ConstructiveToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param filePath The file path to load constructive toy data from
     */
    public ConstructiveToyDAOImpl(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Retrieves all constructive toys from the database.
     *
     * @return A list containing all constructive toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the
     *                          database
     */
    @Override
    public List<ConstructiveToy> getAllToys() {
        List<ConstructiveToy> constructiveToys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // Skip the header

            String line; // Read the rest of the lines
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                ConstructiveToy toy = createConstructiveToy(row);
                constructiveToys.add(toy);
            }

            return constructiveToys;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    /**
     * Creates a ConstructiveToy object from the given values.
     *
     * @param values An array containing the attributes of the constructive toy
     * @return A ConstructiveToy object initialized with the provided attributes
     */
    private ConstructiveToy createConstructiveToy(String[] values) {
        String id = values[0]; // Use the first value as the ID
        String name = values[1]; // Use the second value as the name
        String category = values[2]; // Use the third value as the category
        double price = Double.parseDouble(values[3]); // Use the fourth value as the price
        int recommendedAge = Integer.parseInt(values[4]); // Use the fifth value as the recommended age
        String material = values[5];

        // Create the ConstructiveToy object
        return new ConstructiveToy.ConstructiveToyBuilder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .recommendedAge(recommendedAge)
                .material(material)
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param id The ID of the constructive toy to delete
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
     * @param id The ID of the constructive toy to retrieve
     * @return A ConstructiveToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public ConstructiveToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The constructive toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(ConstructiveToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The constructive toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(ConstructiveToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
