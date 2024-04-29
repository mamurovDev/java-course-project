package com.itpu.warehouse.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.itpu.warehouse.dao.SoftToyDAO;
import com.itpu.warehouse.entity.SoftToy;

public class SoftToyDAOImpl implements SoftToyDAO {

    private String path = "../../../../../../resources/soft.csv";

    private List<SoftToy> softToys;
    private final String DELIMITER = ",";

    public SoftToyDAOImpl() {

    }

    public SoftToyDAOImpl(String path) {
        this.path = path;
    }

    @Override
    public List<SoftToy> getAllToys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            softToys = reader.lines()
                    .skip(1)
                    .map(e -> createPuzzleToy(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
        return softToys;
    }

    private SoftToy createPuzzleToy(String[] values) {
        return new SoftToy.SoftToyBuilder()
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
    public SoftToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    @Override
    public void saveToy(SoftToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    @Override
    public void updateToy(SoftToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
