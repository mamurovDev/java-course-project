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