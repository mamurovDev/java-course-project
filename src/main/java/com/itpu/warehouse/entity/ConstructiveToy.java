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
        return "ConstructiveToy [id=" + id + ", name=" + name + ", category="
                + category + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price);
    }
}