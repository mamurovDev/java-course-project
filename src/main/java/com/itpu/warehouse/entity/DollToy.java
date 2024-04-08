package com.itpu.warehouse.entity;

import java.util.Objects;

/**
 * DollToy
 */
public class DollToy {
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

    private String id;
    private String name;
    private String category;
    private double price;

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
        return "DollToy [id=" + id + ", name=" + name + ", category="
                + category + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price);
    }
}