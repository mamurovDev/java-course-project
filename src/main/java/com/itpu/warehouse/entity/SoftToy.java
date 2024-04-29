package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a soft toy, extending the abstract class Toy.
 */
public class SoftToy extends Toy {
    private final String id;              // The unique identifier of the soft toy
    private final String name;            // The name of the soft toy
    private final String category;        // The category of the soft toy
    private final double price;           // The price of the soft toy
    private final int recommendedAge;     // The recommended age for the soft toy

    /**
     * Constructs a new SoftToy object using a SoftToyBuilder.
     *
     * @param builder The SoftToyBuilder object to construct the SoftToy
     */
    private SoftToy(SoftToyBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    /**
     * Builder class for constructing SoftToy objects.
     */
    public static class SoftToyBuilder extends Builder<SoftToy, SoftToyBuilder> {
        // Required parameters
        private String id;              // The unique identifier of the soft toy
        private String name;            // The name of the soft toy

        // Optional parameters
        private String category;        // The category of the soft toy
        private double price;           // The price of the soft toy
        private int recommendedAge;     // The recommended age for the soft toy

        /**
         * Sets the id of the soft toy.
         *
         * @param id The id to set
         * @return This SoftToyBuilder object
         */
        public SoftToyBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the name of the soft toy.
         *
         * @param name The name to set
         * @return This SoftToyBuilder object
         */
        public SoftToyBuilder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the category of the soft toy.
         *
         * @param category The category to set
         * @return This SoftToyBuilder object
         */
        public SoftToyBuilder category(String category) {
            this.category = category;
            return this;
        }

        /**
         * Sets the price of the soft toy.
         *
         * @param price The price to set
         * @return This SoftToyBuilder object
         */
        public SoftToyBuilder price(double price) {
            this.price = price;
            return this;
        }

        /**
         * Sets the recommended age for the soft toy.
         *
         * @param recommendedAge The recommended age to set
         * @return This SoftToyBuilder object
         */
        public SoftToyBuilder recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return this;
        }

        /**
         * Builds the SoftToy object.
         *
         * @return The constructed SoftToy object
         */
        public SoftToy build() {
            return new SoftToy(this);
        }

        /**
         * Returns the instance of the SoftToyBuilder.
         *
         * @return This SoftToyBuilder object
         */
        protected SoftToyBuilder self() {
            return this;
        }
    }

    /**
     * Gets the id of the soft toy.
     *
     * @return The id of the soft toy
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the soft toy.
     *
     * @return The name of the soft toy
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the category of the soft toy.
     *
     * @return The category of the soft toy
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the price of the soft toy.
     *
     * @return The price of the soft toy
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the recommended age for the soft toy.
     *
     * @return The recommended age for the soft toy
     */
    public int getRecommendedAge() {
        return recommendedAge;
    }

    /**
     * Checks if the soft toy is equal to another object.
     *
     * @param obj The object to compare
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        SoftToy softToy = (SoftToy) obj;
        return Double.compare(softToy.price, price) == 0 &&
                recommendedAge == softToy.recommendedAge &&
                Objects.equals(id, softToy.id) &&
                Objects.equals(name, softToy.name) &&
                Objects.equals(category, softToy.category);
    }

    /**
     * Returns a string representation of the soft toy.
     *
     * @return A string representation of the soft toy
     */
    @Override
    public String toString() {
        return "SoftToy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", recommendedAge=" + recommendedAge +
                '}';
    }

    /**
     * Returns the hash code of the soft toy.
     *
     * @return The hash code of the soft toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }
}
