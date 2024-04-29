package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a puzzle toy, extending the abstract class Toy.
 */
public class PuzzleToy extends Toy {
    private String id;                  // The unique identifier of the puzzle toy
    private String name;                // The name of the puzzle toy
    private String category;            // The category of the puzzle toy
    private double price;               // The price of the puzzle toy
    private int recommendedAge;         // The recommended age for the puzzle toy

    /**
     * Constructs a new PuzzleToy object using a PuzzleToyBuilder.
     *
     * @param builder The PuzzleToyBuilder object to construct the PuzzleToy
     */
    private PuzzleToy(PuzzleToyBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    /**
     * Builder class for constructing PuzzleToy objects.
     */
    public static class PuzzleToyBuilder extends Builder<PuzzleToy, PuzzleToyBuilder> {
        // Required parameters
        private String id;              // The unique identifier of the puzzle toy
        private String name;            // The name of the puzzle toy

        // Optional parameters
        private String category;        // The category of the puzzle toy
        private double price;           // The price of the puzzle toy
        private int recommendedAge;     // The recommended age for the puzzle toy

        /**
         * Sets the id of the puzzle toy.
         *
         * @param id The id to set
         * @return This PuzzleToyBuilder object
         */
        public PuzzleToyBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the name of the puzzle toy.
         *
         * @param name The name to set
         * @return This PuzzleToyBuilder object
         */
        public PuzzleToyBuilder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the category of the puzzle toy.
         *
         * @param category The category to set
         * @return This PuzzleToyBuilder object
         */
        public PuzzleToyBuilder category(String category) {
            this.category = category;
            return this;
        }

        /**
         * Sets the price of the puzzle toy.
         *
         * @param price The price to set
         * @return This PuzzleToyBuilder object
         */
        public PuzzleToyBuilder price(double price) {
            this.price = price;
            return this;
        }

        /**
         * Sets the recommended age for the puzzle toy.
         *
         * @param recommendedAge The recommended age to set
         * @return This PuzzleToyBuilder object
         */
        public PuzzleToyBuilder recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
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
     * Gets the id of the puzzle toy.
     *
     * @return The id of the puzzle toy
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the puzzle toy.
     *
     * @return The name of the puzzle toy
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the category of the puzzle toy.
     *
     * @return The category of the puzzle toy
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the price of the puzzle toy.
     *
     * @return The price of the puzzle toy
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the recommended age for the puzzle toy.
     *
     * @return The recommended age for the puzzle toy
     */
    public int getRecommendedAge() {
        return recommendedAge;
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

        if (obj == null || !(obj instanceof Toy)) {
            return false;
        }

        Toy other = (Toy) obj;

        return this.id.equals(other.getId()) &&
                this.name.equals(other.getName()) &&
                this.category.equals(other.getCategory()) &&
                Double.compare(price, other.getPrice()) == 0;
    }

    /**
     * Returns a string representation of the puzzle toy.
     *
     * @return A string representation of the puzzle toy
     */
    @Override
    public String toString() {
        return "PuzzleToy [id=" + id + ", name=" + name + ", category="
                + category + ", price=" + price + ", recommendedAge=" + recommendedAge + "]";
    }

    /**
     * Returns the hash code of the puzzle toy.
     *
     * @return The hash code of the puzzle toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }
}
