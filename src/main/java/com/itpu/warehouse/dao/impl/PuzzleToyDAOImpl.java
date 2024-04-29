package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.PuzzleToyDAO;
import com.itpu.warehouse.entity.PuzzleToy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the PuzzleToyDAO interface for accessing and manipulating data of PuzzleToy objects in the database.
 */
public class PuzzleToyDAOImpl implements PuzzleToyDAO {
    private String path = "../../../../../../resources/puzzle.csv";

    private List<PuzzleToy> puzzleToys;
    private final String DELIMITER = ",";

    /**
     * Default constructor.
     */
    public PuzzleToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param path The file path to load puzzle toy data from
     */
    public PuzzleToyDAOImpl(String path) {
        this.path = path;
    }

    /**
     * Retrieves all puzzle toys from the database.
     *
     * @return A list containing all puzzle toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the database
     */
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

    /**
     * Creates a PuzzleToy object from the given values.
     *
     * @param values An array containing the attributes of the puzzle toy
     * @return A PuzzleToy object initialized with the provided attributes
     */
    private PuzzleToy createPuzzleToy(String[] values) {
        return new PuzzleToy.PuzzleToyBuilder()
                .name(values[0])
                .category(values[1])
                .price(Double.parseDouble(values[2]))
                .build();
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the puzzle toy to delete
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void deleteToy(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param id The ID of the puzzle toy to retrieve
     * @return A PuzzleToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public PuzzleToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The puzzle toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(PuzzleToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented yet.
     *
     * @param toy The puzzle toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(PuzzleToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
