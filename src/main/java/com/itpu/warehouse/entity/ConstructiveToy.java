package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a constructive toy, extending the abstract class Toy.
 */
public class ConstructiveToy extends Toy {
    private String id;                  // The unique identifier of the constructive toy
    private String name;                // The name of the constructive toy
    private String category;            // The category of the constructive toy
    private double price;               // The price of the constructive toy
    private int recommendedAge;         // The recommended age for the constructive toy

    /**
     * Constructs a new ConstructiveToy object using a ConstructiveToyBuilder.
     *
     * @param builder The ConstructiveToyBuilder object to construct the ConstructiveToy
     */
    public ConstructiveToy(ConstructiveToyBuilder builder) {
        super(builder);
        this.category = builder.category;
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    /**
     * Builder class for constructing ConstructiveToy objects.
     */
    public static class ConstructiveToyBuilder extends Builder<ConstructiveToy, ConstructiveToyBuilder> {
        private String id;              // The unique identifier of the constructive toy
        private String name;            // The name of the constructive toy
        private String category;        // The category of the constructive toy
        private double price;           // The price of the constructive toy
        private int recommendedAge;     // The recommended age for the constructive toy

        /**
         * Sets the id of the constructive toy.
         *
         * @param id The id to set
         * @return This ConstructiveToyBuilder object
         */
        public ConstructiveToyBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the name of the constructive toy.
         *
         * @param name The name to set
         * @return This ConstructiveToyBuilder object
         */
        public ConstructiveToyBuilder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the category of the constructive toy.
         *
         * @param category The category to set
         * @return This ConstructiveToyBuilder object
         */
        public ConstructiveToyBuilder category(String category) {
            this.category = category;
            return this;
        }

        /**
         * Sets the price of the constructive toy.
         *
         * @param price The price to set
         * @return This ConstructiveToyBuilder object
         */
        public ConstructiveToyBuilder price(double price) {
            this.price = price;
            return this;
        }

        /**
         * Sets the recommended age for the constructive toy.
         *
         * @param recommendedAge The recommended age to set
         * @return This ConstructiveToyBuilder object
         */
        public ConstructiveToyBuilder recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return this;
        }

        /**
         * Builds the ConstructiveToy object.
         *
         * @return The constructed ConstructiveToy object
         */
        public ConstructiveToy build() {
            return new ConstructiveToy(this);
        }

        /**
         * Returns the instance of the ConstructiveToyBuilder.
         *
         * @return This ConstructiveToyBuilder object
         */
        public ConstructiveToyBuilder self() {
            return this;
        }
    }

    /**
     * Gets the id of the constructive toy.
     *
     * @return The id of the constructive toy
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the constructive toy.
     *
     * @return The name of the constructive toy
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the category of the constructive toy.
     *
     * @return The category of the constructive toy
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the price of the constructive toy.
     *
     * @return The price of the constructive toy
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the recommended age for the constructive toy.
     *
     * @return The recommended age for the constructive toy
     */
    public int getRecommendedAge() {
        return recommendedAge;
    }

    /**
     * Checks if the constructive toy is equal to another object.
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
                this.recommendedAge == other.getRecommendedAge() &&
                this.name.equals(other.getName()) &&
                this.category.equals(other.getCategory()) &&
                Double.compare(price, other.getPrice()) == 0;
    }

    /**
     * Returns a string representation of the constructive toy.
     *
     * @return A string representation of the constructive toy
     */
    @Override
    public String toString() {
        return "ConstructiveToy [id=" + id + ", name=" + name + ", category="
                + category + ", price=" + price + ", recommendedAge=" + recommendedAge + "]";
    }

    /**
     * Returns the hash code of the constructive toy.
     *
     * @return The hash code of the constructive toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }
}
