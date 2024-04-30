package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a puzzle toy, extending the abstract class Toy.
 */
public class PuzzleToy extends Toy {

    private final String difficulty; // e.g. easy, medium, hard

    /**
     * Gets the difficulty of the puzzle toy.
     * 
     * @return The difficulty of the puzzle toy
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Constructs a new PuzzleToy object using a PuzzleToyBuilder.
     *
     * @param builder The PuzzleToyBuilder object to construct the PuzzleToy
     */
    private PuzzleToy(PuzzleToyBuilder builder) {
        super(builder);
        this.difficulty = builder.difficulty;
    }

    /**
     * Builder class for constructing PuzzleToy objects.
     */
    public static class PuzzleToyBuilder extends Builder<PuzzleToy, PuzzleToyBuilder> {
        private String difficulty; // e.g. easy, medium, hard

        /**
         * Sets the difficulty of the puzzle toy.
         * 
         * @param difficulty
         * @return PuzzleToyBuilder
         */
        public PuzzleToyBuilder difficulty(String difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        /**
         * Builds the PuzzleToy object.
         *
         * @return The constructed PuzzleToy object
         */
        public PuzzleToy build() {
            return new PuzzleToy(this);
        }

        /**
         * Returns the instance of the PuzzleToyBuilder.
         *
         * @return This PuzzleToyBuilder object
         */
        public PuzzleToyBuilder self() {
            return this;
        }
    }

    /**
     * Checks if the puzzle toy is equal to another object.
     *
     * @param obj The object to compare
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof PuzzleToy)) {
            return false;
        }

        PuzzleToy puzzleToy = (PuzzleToy) obj;

        return super.equals(obj) &&
                Objects.equals(difficulty, puzzleToy.difficulty);
    }

    /**
     * Returns a string representation of the puzzle toy.
     *
     * @return A string representation of the puzzle toy
     */
    @Override
    public String toString() {
        return "PuzzleToy{" + "id = " + getId() + ", name = " + getName() + ", category = " + getCategory()
                + ", price = " + getPrice() + ", recommendedAge = " + getRecommendedAge() + ", difficulty = "
                + difficulty + '}';
    }

    /**
     * Returns the hash code of the puzzle toy.
     *
     * @return The hash code of the puzzle toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getPrice(), getRecommendedAge(), difficulty);
    }
}
