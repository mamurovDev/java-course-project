package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.VehicleToyDAO;
import com.itpu.warehouse.entity.VehicleToy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the VehicleToyDAO interface for accessing and manipulating data of VehicleToy objects in the database.
 */
public class VehicleToyDAOImpl implements VehicleToyDAO {
    private String path = "../../../../../../resources/vehicle.csv";

    private List<VehicleToy> vehicleToys;
    private final String DELIMITER = ",";

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
        this.path = path;
    }

    /**
     * Retrieves all vehicle toys from the database.
     *
     * @return A list containing all vehicle toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the database
     */
    @Override
    public List<VehicleToy> getAllToys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            vehicleToys = reader.lines()
                    .skip(1)
                    .map(e -> createVehicleToy(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
        return vehicleToys;
    }

    /**
     * Creates a VehicleToy object from the given values.
     *
     * @param values An array containing the attributes of the vehicle toy
     * @return A VehicleToy object initialized with the provided attributes
     */
    private VehicleToy createVehicleToy(String[] values) {
        return new VehicleToy.VehicleToyBuilder()
                .name(values[0])
                .category(values[1])
                .price(Double.parseDouble(values[2]))
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the vehicle toy to delete
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void deleteToy(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
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
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The vehicle toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(VehicleToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The vehicle toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(VehicleToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
