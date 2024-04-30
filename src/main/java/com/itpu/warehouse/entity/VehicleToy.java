package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * Represents a vehicle toy, extending the abstract class Toy.
 */
public class VehicleToy extends Toy {

    private final int numberOfWheels; // Number of wheels on the vehicle toy

    /**
     * Returns the number of wheels on the vehicle toy.
     * 
     * @return The number of wheels
     */
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    /**
     * Constructs a new VehicleToy object using a VehicleToyBuilder.
     *
     * @param builder The VehicleToyBuilder object to construct the VehicleToy
     */
    public VehicleToy(VehicleToyBuilder builder) {
        super(builder);
        this.numberOfWheels = builder.numberOfWheels;
    }

    /**
     * Builder class for constructing VehicleToy objects.
     */
    public static class VehicleToyBuilder extends Builder<VehicleToy, VehicleToyBuilder> {

        private int numberOfWheels; // Number of wheels on the vehicle toy

        /**
         * 
         * @param numberOfWheels
         * @return VehicleToyBuilder
         */
        public VehicleToyBuilder numberOfWheels(int numberOfWheels) {
            this.numberOfWheels = numberOfWheels;
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
     * Checks if the vehicle toy is equal to another object.
     *
     * @param obj The object to compare
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof VehicleToy))
            return false;
        VehicleToy vehicleToy = (VehicleToy) obj;
        return super.equals(obj) &&
                Double.compare(vehicleToy.getNumberOfWheels(), numberOfWheels) == 0;
    }

    /**
     * Returns a string representation of the vehicle toy.
     *
     * @return A string representation of the vehicle toy
     */
    @Override
    public String toString() {
        return "VehicleToy [id=" + getId() + ", name=" + getName() + ", category="
                + getCategory() + ", price=" + getPrice() + ", recommendedAge=" + getRecommendedAge() +
                ", numberOfWheels=" + numberOfWheels + "]";
    }

    /**
     * Returns the hash code of the vehicle toy.
     *
     * @return The hash code of the vehicle toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getPrice(), getRecommendedAge(), numberOfWheels);
    }
}
