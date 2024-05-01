package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.VehicleToyDAO;
import com.itpu.warehouse.entity.VehicleToy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the VehicleToyDAO interface for accessing and manipulating
 * data of VehicleToy objects in the database.
 */
public class VehicleToyDAOImpl implements VehicleToyDAO {
    private final String DELIMITER = ","; // Adjust the delimiter as needed
    String filePath = "src/main/resources/vehicle_toys.csv"; // Adjust the file path with correct extension

    /**
     * Default constructor.
     */
    public VehicleToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param path The file path to load vehicle toy data from
     */
    public VehicleToyDAOImpl(String path) {
        this.filePath = path;
    }

    /**
     * Retrieves all vehicle toys from the database.
     *
     * @return A list containing all vehicle toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the
     *                          database
     */
    @Override
    public List<VehicleToy> getAllToys() {
        List<VehicleToy> vehicleToys = new ArrayList<>(); // Initialize the list
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip the header

            String line; // Read the rest of the lines
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                VehicleToy toy = createVehicleToy(row);
                vehicleToys.add(toy);
            }
            return vehicleToys;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    /**
     * Creates a VehicleToy object from the given values.
     *
     * @param values An array containing the attributes of the vehicle toy
     * @return A VehicleToy object initialized with the provided attributes
     */
    private VehicleToy createVehicleToy(String[] values) {
        String id = values[0]; // Use the first value as the ID
        String name = values[1]; // Use the second value as the name
        String category = values[2]; // Use the third value as the category
        double price = Double.parseDouble(values[3]); // Use the fourth value as the price
        int recommendedAge = Integer.parseInt(values[4]); // Use the fifth value as the recommended age
        int numberOfWheels = Integer.parseInt(values[5]); // Use the sixth value as the number of wheels
        return new VehicleToy.VehicleToyBuilder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .recommendedAge(recommendedAge)
                .numberOfWheels(numberOfWheels)
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param id The ID of the vehicle toy to delete
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
     * @param id The ID of the vehicle toy to retrieve
     * @return A VehicleToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public VehicleToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The vehicle toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(VehicleToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The vehicle toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(VehicleToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
