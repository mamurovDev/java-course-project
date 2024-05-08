package com.itpu.warehouse.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.List;
import java.util.ArrayList;

import com.itpu.warehouse.dao.SoftToyDAO;
import com.itpu.warehouse.entity.SoftToy;

/**
 * Implementation of the SoftToyDAO interface for accessing and manipulating
 * data of SoftToy objects in the database.
 */
public class SoftToyDAOImpl implements SoftToyDAO {

    private final String DELIMITER = ","; // Adjust the delimiter as needed
    String filePath = "src/main/resources/soft_toys.csv"; // Adjust the file path with correct extension

    /**
     * Constructor with default file path.
     * 
     * @throws RuntimeException If an error occurs while accessing or reading
     */
    public SoftToyDAOImpl() {
    }

    /**
     * Constructor with a custom file path.
     *
     * @param path The file path to load soft toy data from
     * @throws RuntimeException If an error occurs while accessing or reading the
     */
    public SoftToyDAOImpl(String path) {
        this.filePath = path;
    }

    /**
     * Retrieves all soft toys from the database.
     *
     * @return A list containing all soft toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the
     *                          database
     */
    @Override
    public List<SoftToy> getAllToys() {
        List<SoftToy> softToys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // Skip the header
            String line;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                SoftToy toy = createSoftToy(row);
                softToys.add(toy);

            }
            reader.close();
            return softToys;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    /**
     * Creates a SoftToy object from the given values.
     *
     * @param values An array containing the attributes of the soft toy
     * @return A SoftToy object initialized with the provided attributes
     */
    private SoftToy createSoftToy(String[] values) {
        String id = values[0]; // Use the first value as the ID
        String name = values[1]; // Use the second value as the name
        String category = values[2]; // Use the third value as the category
        double price = Double.parseDouble(values[3]); // Use the fourth value as the price
        int recommendedAge = Integer.parseInt(values[4]); // Use the fifth value as the recommended age
        double mass = Double.parseDouble(values[5]); // Use the sixth value as the mass

        // Create the SoftToy object
        return new SoftToy.SoftToyBuilder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .recommendedAge(recommendedAge)
                .mass(mass)
                .build();
    }

    /**
     * Searches for constructive toys in the database based on the provided
     * category.
     * 
     * @param category The category to search for
     * @throws RuntimeException If an error occurs while accessing or reading the
     */
    public List<SoftToy> findByCategory(String category) {
        List<SoftToy> softToys = new ArrayList<>(); // Initialize the list
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // Skip the header

            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                if (row[2].equals(category)) {
                    SoftToy toy = createSoftToy(row);
                    softToys.add(toy);
                }
            }

            reader.close();

            return softToys;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    /**
     * Searches for vehicle toys in the database based on the provided price
     * range.
     * 
     * @param minPrice The minimum price to search for.
     * @param maxPrice The maximum price to search for.
     * @throws RuntimeException If an error occurs while accessing or reading the.
     */

    public List<SoftToy> findByPriceRange(double minPrice, double maxPrice) {
        List<SoftToy> softToys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // Skip the header

            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                double price = Double.parseDouble(row[3]);
                if (price >= minPrice && price <= maxPrice) {
                    SoftToy toy = createSoftToy(row);
                    softToys.add(toy);
                }
            }

            reader.close();

            return softToys;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param id The ID of the soft toy to delete
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
     * @param id The ID of the soft toy to retrieve
     * @return A SoftToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public SoftToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The soft toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(SoftToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The soft toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(SoftToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
