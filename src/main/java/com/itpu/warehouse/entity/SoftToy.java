package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a soft toy, extending the abstract class Toy.
 */
public class SoftToy extends Toy {

    private final double mass; // The mass of the soft toy in kilograms

    /**
     * Constructs a new SoftToy object using a SoftToyBuilder.
     *
     * @param builder The SoftToyBuilder object to construct the SoftToy
     */
    private SoftToy(SoftToyBuilder builder) {
        super(builder);
        this.mass = builder.mass;
    }

    /**
     * Gets the mass of the soft toy in kilograms.
     * 
     * @return The mass of the soft toy
     */
    public double getMass() {
        return mass;
    }

    /**
     * Builder class for constructing SoftToy objects.
     */
    public static class SoftToyBuilder extends Builder<SoftToy, SoftToyBuilder> {

        private double mass; // The mass of the soft toy in kilograms

        /**
         * Sets the mass of the soft toy.
         * 
         * @param mass
         * @return SoftToyBuilder
         */
        public SoftToyBuilder mass(double mass) {
            this.mass = mass;
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
     * Checks if the soft toy is equal to another object.
     *
     * @param obj The object to compare
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof SoftToy))
            return false;
        SoftToy softToy = (SoftToy) obj;
        return super.equals(obj) &&
                Double.compare(softToy.getMass(), mass) == 0;
    }

    /**
     * Returns a string representation of the soft toy.
     *
     * @return A string representation of the soft toy
     */
    @Override
    public String toString() {
        return "SoftToy{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", price=" + getPrice() +
                ", recommendedAge=" + getRecommendedAge() +
                ", mass=" + mass +
                '}';
    }

    /**
     * Returns the hash code of the soft toy.
     *
     * @return The hash code of the soft toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getPrice(), getRecommendedAge(), mass);
    }
}
