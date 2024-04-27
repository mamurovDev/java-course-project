package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * ConstructiveToy
 */
public class ConstructiveToy extends Toy {

    private String id;
    private String name;
    private String category;
    private double price;
    private int recommendedAge;

    public ConstructiveToy(Builder builder) {
        this.category = builder.category;
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    public static class Builder {

        private String id;
        private String name;
        private String category;
        private double price;
        private int recommendedAge;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return this;
        }

        public ConstructiveToy build() {
            return new ConstructiveToy(this);
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public double getPrice() {
        return this.price;
    }

    public int getRecommendedAge() {
        return this.recommendedAge;
    }

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

    @Override
    public String toString() {
        return "ConstructiveToy [id=" + id + ", name=" + name + ", category="
                + category + ", price=" + price + ", recommendedAge=" + recommendedAge + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }
}