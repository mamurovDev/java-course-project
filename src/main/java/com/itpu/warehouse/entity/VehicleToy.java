package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a vehicle toy, extending the abstract class Toy.
 */
public class VehicleToy extends Toy {
    private String id;                  // The unique identifier of the vehicle toy
    private String name;                // The name of the vehicle toy
    private String category;            // The category of the vehicle toy
    private double price;               // The price of the vehicle toy
    private int recommendedAge;         // The recommended age for the vehicle toy

    /**
     * Constructs a new VehicleToy object using a VehicleToyBuilder.
     *
     * @param builder The VehicleToyBuilder object to construct the VehicleToy
     */
    public VehicleToy(VehicleToyBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    /**
     * Builder class for constructing VehicleToy objects.
     */
    public static class VehicleToyBuilder extends Builder<VehicleToy, VehicleToyBuilder> {
        private String id;              // The unique identifier of the vehicle toy
        private String name;            // The name of the vehicle toy
        private String category;        // The category of the vehicle toy
        private double price;           // The price of the vehicle toy
        private int recommendedAge;     // The recommended age for the vehicle toy

        /**
         * Sets the id of the vehicle toy.
         *
         * @param id The id to set
         * @return This VehicleToyBuilder object
         */
        public VehicleToyBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the name of the vehicle toy.
         *
         * @param name The name to set
         * @return This VehicleToyBuilder object
         */
        public VehicleToyBuilder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the category of the vehicle toy.
         *
         * @param category The category to set
         * @return This VehicleToyBuilder object
         */
        public VehicleToyBuilder category(String category) {
            this.category = category;
            return this;
        }

        /**
         * Sets the price of the vehicle toy.
         *
         * @param price The price to set
         * @return This VehicleToyBuilder object
         */
        public VehicleToyBuilder price(double price) {
            this.price = price;
            return this;
        }

        /**
         * Sets the recommended age for the vehicle toy.
         *
         * @param recommendedAge The recommended age to set
         * @return This VehicleToyBuilder object
         */
        public VehicleToyBuilder recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return this;
        }

        /**
         * Builds the VehicleToy object.
         *
         * @return The constructed VehicleToy object
         */
        public VehicleToy build() {
            return new VehicleToy(this);
        }

        /**
         * Returns the instance of the VehicleToyBuilder.
         *
         * @return This VehicleToyBuilder object
         */
        public VehicleToyBuilder self() {
            return this;
        }

    }

    /**
     * Gets the id of the vehicle toy.
     *
     * @return The id of the vehicle toy
     */
    public String getId() {
        return this.id;
    }

    /**
     * Gets the name of the vehicle toy.
     *
     * @return The name of the vehicle toy
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the category of the vehicle toy.
     *
     * @return The category of the vehicle toy
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Gets the price of the vehicle toy.
     *
     * @return The price of the vehicle toy
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the recommended age for the vehicle toy.
     *
     * @return The recommended age for the vehicle toy
     */
    public int getRecommendedAge() {
        return this.recommendedAge;
    }

    /**
     * Checks if the vehicle toy is equal to another object.
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
     * Returns a string representation of the vehicle toy.
     *
     * @return A string representation of the vehicle toy
     */
    @Override
    public String toString() {
        return "VehicleToy [id=" + id + ", name=" + name + ", category="
                + category + ", price=" + price + ", recommendedAge=" + recommendedAge + "]";
    }

    /**
     * Returns the hash code of the vehicle toy.
     *
     * @return The hash code of the vehicle toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }
}
