package com.itpu.warehouse.entity;

import java.util.Objects;

import com.itpu.warehouse.enums.Gender;

public class DollToy extends Toy {

    private final Gender gender; // The gender of the doll toy

    /**
     * Gets the gender of the doll toy.
     * 
     * @return The gender of the doll toy
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Constructs a new DollToy object using a DollToyBuilder.
     *
     * @param builder The DollToyBuilder object to construct the DollToy
     */
    public DollToy(DollToyBuilder builder) {
        super(builder);
        this.gender = builder.gender;
    }

    /**
     * Builder class for constructing DollToy objects.
     */
    public static class DollToyBuilder extends Builder<DollToy, DollToyBuilder> {
        private Gender gender; // The gender of the doll toy

        public DollToyBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        /**
         * Builds the DollToy object.
         *
         * @return The constructed DollToy object
         */
        public DollToy build() {
            return new DollToy(this);
        }

        /**
         * Returns the instance of the DollToyBuilder.
         *
         * @return This DollToyBuilder object
         */
        public DollToyBuilder self() {
            return this;
        }
    }

    /**
     * Checks if the doll toy is equal to another object.
     *
     * @param obj The object to compare
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof DollToy)) {
            return false;
        }

        DollToy dollToy = (DollToy) obj;

        return super.equals(obj) &&
                Objects.equals(gender, dollToy.gender);
    }

    /**
     * Returns a string representation of the doll toy.
     *
     * @return A string representation of the doll toy
     */
    @Override
    public String toString() {
        return "DollToy{" + "id = " + getId() + ", name = " + getName() + ", category = " + getCategory() + ", price = "
                + getPrice() + ", recommendedAge = " + getRecommendedAge() + ", gender = " + gender + '}';
    }

    /**
     * Returns the hash code of the doll toy.
     *
     * @return The hash code of the doll toy
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getPrice(), getRecommendedAge(), gender);
    }
}
