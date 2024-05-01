package com.itpu.warehouse.dao.impl;

import com.itpu.warehouse.dao.PuzzleToyDAO;
import com.itpu.warehouse.entity.PuzzleToy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the PuzzleToyDAO interface for accessing and manipulating
 * data of PuzzleToy objects in the database.
 */
public class PuzzleToyDAOImpl implements PuzzleToyDAO {
    private final String DELIMITER = ","; // Adjust the delimiter as needed
    String filePath = "src/main/resources/puzzle_toys.csv"; // Adjust the file path with correct extension

    /**
     * Default constructor.
     */
    public PuzzleToyDAOImpl() {

    }

    /**
     * Constructor with a custom file path.
     *
     * @param filePath The file path to load puzzle toy data from
     */
    public PuzzleToyDAOImpl(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Retrieves all puzzle toys from the database.
     *
     * @return A list containing all puzzle toys stored in the database
     * @throws RuntimeException If an error occurs while accessing or reading the
     *                          database
     */
    @Override
    public List<PuzzleToy> getAllToys() {
        List<PuzzleToy> puzzleToys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line; // Read the rest of the lines

            reader.readLine(); // Skip the header

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                PuzzleToy toy = createPuzzleToy(row);
                puzzleToys.add(toy);
            }
            return puzzleToys;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    /**
     * Creates a PuzzleToy object from the given values.
     *
     * @param values An array containing the attributes of the puzzle toy
     * @return A PuzzleToy object initialized with the provided attributes
     */
    private PuzzleToy createPuzzleToy(String[] values) {
        String id = values[0]; // Use the first value as the ID
        String name = values[1]; // Use the second value as the name
        String category = values[2]; // Use the third value as the category
        double price = Double.parseDouble(values[3]); // Use the fourth value as the price
        int recommendedAge = parseRecommendedAge(values[4]); // Use the fifth value as the recommended age
        String difficulty = values[5];
        return new PuzzleToy.PuzzleToyBuilder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .recommendedAge(recommendedAge)
                .difficulty(difficulty)
                .build();
    }

    /**
     * Parses the recommended age from the provided string.
     * If the string contains a "+", it extracts the numeric part before the "+".
     * If no numeric part is found, it returns 0.
     *
     * @param recommendedAgeStr The recommended age string to parse
     * @return The parsed recommended age as an integer
     */
    private int parseRecommendedAge(String recommendedAgeStr) {
        String numericPart = recommendedAgeStr.split("\\+")[0]; // Extract the numeric part before the "+"
        try {
            return Integer.parseInt(numericPart);
        } catch (NumberFormatException e) {
            return 0; // Return 0 if no numeric part is found
        }
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param id The ID of the puzzle toy to delete
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
     * @param id The ID of the puzzle toy to retrieve
     * @return A PuzzleToy object corresponding to the provided ID
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public PuzzleToy getToyById(String id) {
        throw new RuntimeException("This method is not implemented yet");
    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The puzzle toy to save
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void saveToy(PuzzleToy toy) {
        throw new RuntimeException("This method is not implemented yet");

    }

    /**
     * Throws a runtime exception indicating that this method is not implemented
     * yet.
     *
     * @param toy The puzzle toy to update
     * @throws RuntimeException Always throws a runtime exception
     */
    @Override
    public void updateToy(PuzzleToy toy) {
        throw new RuntimeException("This method is not implemented yet");
    }
}
