package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Abstract class representing a toy.
 */
public abstract class Toy {
    private String id; // The unique identifier of the toy
    private String name; // The name of the toy
    private String category; // The category of the toy
    private double price; // The price of the toy
    private int recommendedAge; // The recommended age for the toy

    /**
     * Constructs a new Toy object using a Builder.
     *
     * @param builder The Builder object to construct the Toy
     */
    protected Toy(Builder<? extends Toy, ?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    /**
     * Abstract Builder class for constructing Toy objects.
     *
     * @param <T> The type of Toy being built
     * @param <B> The type of Builder being used
     */
    public static abstract class Builder<T extends Toy, B extends Builder<T, B>> {
        private String id; // The unique identifier of the toy
        private String name; // The name of the toy
        private String category; // The category of the toy
        private double price; // The price of the toy
        private int recommendedAge; // The recommended age for the toy

        /**
         * Sets the id of the toy.
         *
         * @param id The id to set
         * @return This Builder object
         */
        public B id(String id) {
            this.id = id;
            return self();
        }

        /**
         * Sets the name of the toy.
         *
         * @param name The name to set
         * @return This Builder object
         */
        public B name(String name) {
            this.name = name;
            return self();
        }

        /**
         * Sets the category of the toy.
         *
         * @param category The category to set
         * @return This Builder object
         */
        public B category(String category) {
            this.category = category;
            return self();
        }

        /**
         * Sets the price of the toy.
         *
         * @param price The price to set
         * @return This Builder object
         */
        public B price(double price) {
            this.price = price;
            return self();
        }

        /**
         * Sets the recommended age for the toy.
         *
         * @param recommendedAge The recommended age to set
         * @return This Builder object
         */
        public B recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return self();
        }

        /**
         * Abstract method to build the Toy object.
         *
         * @return The constructed Toy object
         */
        public abstract T build();

        /**
         * Abstract method to return the instance of the Builder.
         *
         * @return This Builder object
         */
        protected abstract B self();
    }

    /**
     * Get the id of the toy.
     *
     * @return The id of the toy
     */
    public String getId() {
        return id;
    }

    /**
     * Get the name of the toy.
     *
     * @return The name of the toy
     */
    public String getName() {
        return name;
    }

    /**
     * Get the category of the toy.
     *
     * @return The category of the toy
     */
    public String getCategory() {
        return category;
    }

    /**
     * Get the price of the toy.
     *
     * @return The price of the toy
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the recommended age for the toy.
     *
     * @return The recommended age for the toy
     */
    public int getRecommendedAge() {
        return recommendedAge;
    }

    /**
     * Returns a string representation of the toy.
     *
     * @return A string representation of the toy
     */
    @Override
    public String toString() {
        return "Toy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", recommendedAge=" + recommendedAge +
                '}';
    }

    /**
     * Checks if the toy is equal to another object.
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
        Toy toy = (Toy) obj;
        return Double.compare(toy.price, price) == 0 &&
                recommendedAge == toy.recommendedAge &&
                Objects.equals(id, toy.id) &&
                Objects.equals(name, toy.name) &&
                Objects.equals(category, toy.category);
    }

    /**
     * Returns the hash code of the toy.
     *
     * @return The hash code of the toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }
}
