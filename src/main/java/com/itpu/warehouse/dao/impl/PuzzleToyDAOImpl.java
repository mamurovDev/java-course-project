package com.itpu.warehouse.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.itpu.warehouse.dao.PuzzleToyDAO;
import com.itpu.warehouse.entity.PuzzleToy;

public class PuzzleToyDAOImpl implements PuzzleToyDAO {
    private String path = "../../../../../../resources/puzzle.csv";

    private List<PuzzleToy> puzzleToys;
    private final String DELIMITER = ",";

    public PuzzleToyDAOImpl() {

    }

    public PuzzleToyDAOImpl(String path) {
        this.path = path;
    }

    @Override
    public List<PuzzleToy> getAllToys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            puzzleToys = reader.lines()
                    .skip(1)
                    .map(e -> createPuzzleToy(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
        return puzzleToys;
    }

    private PuzzleToy createPuzzleToy(String[] values) {
        return new PuzzleToy.Builder()
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
    public PuzzleToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    @Override
    public void saveToy(PuzzleToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    @Override
    public void updateToy(PuzzleToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }

}
