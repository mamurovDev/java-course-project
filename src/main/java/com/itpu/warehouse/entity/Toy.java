package com.itpu.warehouse.entity;

/**
 * Products
 */
public abstract class Toy {
    private String id;
    private String name;
    private String category;
    private double price;
    private int recommendedAge;

    protected Toy(Builder<? extends Toy, ?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.recommendedAge = builder.recommendedAge;
    }

    public static abstract class Builder<T extends Toy, B extends Builder<T, B>> {
        private String id;
        private String name;
        private String category;
        private double price;
        private int recommendedAge;

        public B id(String id) {
            this.id = id;
            return self();
        }

        public B name(String name) {
            this.name = name;
            return self();
        }

        public B category(String category) {
            this.category = category;
            return self();
        }

        public B price(double price) {
            this.price = price;
            return self();
        }

        public B recommendedAge(int recommendedAge) {
            this.recommendedAge = recommendedAge;
            return self();
        }

        public abstract T build();

        protected abstract B self();
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getCategory();

    public abstract double getPrice();

    public abstract int getRecommendedAge();

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
}
