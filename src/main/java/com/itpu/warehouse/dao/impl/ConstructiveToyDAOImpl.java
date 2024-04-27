package com.itpu.warehouse.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import com.itpu.warehouse.dao.ConstructiveToyDAO;
import com.itpu.warehouse.entity.ConstructiveToy;

public class ConstructiveToyDAOImpl implements ConstructiveToyDAO {
    private String path = "../../../../../../resources/constructive.csv";

    private List<ConstructiveToy> constructiveToys;
    private final String DELIMITER = ",";

    public ConstructiveToyDAOImpl() {

    }

    public ConstructiveToyDAOImpl(String path) {
        this.path = path;
    }

    @Override
    public List<ConstructiveToy> getAllToys() {
        try {
            constructiveToys = new BufferedReader(new FileReader(path))
                    .lines()
                    .skip(1)
                    .map(e -> createConstructiveToy(e.split(DELIMITER))).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("File not found");
        }
        return constructiveToys;
    }

    private ConstructiveToy createConstructiveToy(String[] values) {
        return new ConstructiveToy.Builder()
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
    public ConstructiveToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    @Override
    public void saveToy(ConstructiveToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    @Override
    public void updateToy(ConstructiveToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }

}
