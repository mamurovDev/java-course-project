package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * PuzzleToy
 */
public class PuzzleToy extends Toy {
    private String id;
    private String name;
    private String category;
    private double price;
    private int recommendedAge;

    private PuzzleToy(PuzzleToyBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    public static class PuzzleToyBuilder extends Builder<PuzzleToy, PuzzleToyBuilder> {
        // Required parameters
        private String id;
        private String name;

        // Optional parameters
        private String category;
        private double price;
        private int recommendedAge;

        public PuzzleToyBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PuzzleToyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PuzzleToyBuilder category(String category) {
            this.category = category;
            return this;
        }

        public PuzzleToyBuilder price(double price) {
            this.price = price;
            return this;
        }

        public PuzzleToyBuilder recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return this;
        }

        public PuzzleToy build() {
            return new PuzzleToy(this);
        }

        public PuzzleToyBuilder self() {
            return this;
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
                this.name.equals(other.getName()) &&
                this.category.equals(other.getCategory()) &&
                Double.compare(price, other.getPrice()) == 0;
    }

    @Override
    public String toString() {
        return "PuzzleToy [id=" + id + ", name=" + name + ", category="
                + category + ", price=" + price + ", recommendedAge=" + recommendedAge + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price, recommendedAge);
    }
}
