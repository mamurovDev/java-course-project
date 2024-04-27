package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * SoftToy
 */
public class SoftToy extends Toy {
    private String id;
    private String name;
    private String category;
    private double price;
    private int recommendedAge;

    public SoftToy(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    public static class Builder {
        // Required parameters
        private String id;
        private String name;

        // Optional parameters
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

        public SoftToy build() {
            return new SoftToy(this);
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

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }

}