package com.itpu.warehouse.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.itpu.warehouse.dao.DollToyDAO;
import com.itpu.warehouse.entity.ConstructiveToy;
import com.itpu.warehouse.entity.DollToy;

/**
 * DollToyDAOImpl
 */
public class DollToyDAOImpl implements DollToyDAO {
    private String path = "../../../../../../resources/doll.csv";

    private List<DollToy> dollToys;
    private final String DELIMITER = ",";

    public DollToyDAOImpl() {

    }

    public DollToyDAOImpl(String path) {
        this.path = path;
    }

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

    private DollToy createDollToy(String[] values) {
        return new DollToy.Builder()
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
    public DollToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    @Override
    public void saveToy(DollToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    @Override
    public void updateToy(DollToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }

}