package com.itpu.warehouse.entity;

import java.util.Objects;

public class SoftToy extends Toy {

    private final String id;
    private final String name;
    private final String category;
    private final double price;
    private final int recommendedAge;

    private SoftToy(SoftToyBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    public static class SoftToyBuilder extends Builder<SoftToy, SoftToyBuilder> {

        // Required parameters
        private String id;
        private String name;

        // Optional parameters
        private String category;
        private double price;
        private int recommendedAge;

        public SoftToyBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SoftToyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SoftToyBuilder category(String category) {
            this.category = category;
            return this;
        }

        public SoftToyBuilder price(double price) {
            this.price = price;
            return this;
        }

        public SoftToyBuilder recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return this;
        }

        public SoftToy build() {
            return new SoftToy(this);
        }

        protected SoftToyBuilder self() {
            return this;
        }

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getRecommendedAge() {
        return recommendedAge;
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
