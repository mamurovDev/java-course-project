package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.VehicleToyDAO;
import com.itpu.warehouse.entity.VehicleToy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleToyDAOImpl implements VehicleToyDAO {
    private String path = "../../../../../../resources/vehicle.csv";

    private List<VehicleToy> vehicleToys;
    private final String DELIMITER = ",";

    public VehicleToyDAOImpl() {

    }

    public VehicleToyDAOImpl(String path) {
        this.path = path;
    }

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

    private VehicleToy createVehicleToy(String[] values) {
        return new VehicleToy.Builder()
                .name(values[0])
                .category(values[1])
                .price(Double.parseDouble(values[2]))
                .build();
    }

    @Override
    public void deleteToy(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    @Override
    public VehicleToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    @Override
    public void saveToy(VehicleToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    @Override
    public void updateToy(VehicleToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
