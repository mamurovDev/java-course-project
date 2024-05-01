package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a constructive toy, extending the abstract class Toy.
 */
public class ConstructiveToy extends Toy {
    private final String material; // The material of the constructive toy

    /**
     * Gets the material of the constructive toy.
     * 
     * @return The material of the constructive toy
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Constructs a new ConstructiveToy object using a ConstructiveToyBuilder.
     *
     * @param builder The ConstructiveToyBuilder object to construct the
     *                ConstructiveToy
     */
    public ConstructiveToy(ConstructiveToyBuilder builder) {
        super(builder);
        this.material = builder.material;
    }

    /**
     * Builder class for constructing ConstructiveToy objects.
     */
    public static class ConstructiveToyBuilder extends Builder<ConstructiveToy, ConstructiveToyBuilder> {
        private String material; // The material of the constructive toy

        public ConstructiveToyBuilder material(String material) {
            this.material = material;
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

        if (obj == null || !(obj instanceof ConstructiveToy)) {
            return false;
        }

        ConstructiveToy constructiveToy = (ConstructiveToy) obj;

        return super.equals(obj) && Objects.equals(material, constructiveToy.material);
    }

    /**
     * Returns a string representation of the constructive toy.
     *
     * @return A string representation of the constructive toy
     */
    @Override
    public String toString() {
        return "ConstructiveToy{" + "id = " + getId() + ", name = " + getName() + ", category = " + getCategory()
                + ", price = " + getPrice() + ", recommendedAge = " + getRecommendedAge() + ", material = " + material
                + "}";
    }

    /**
     * Returns the hash code of the constructive toy.
     *
     * @return The hash code of the constructive toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getPrice(), getRecommendedAge(), material);
    }
}
