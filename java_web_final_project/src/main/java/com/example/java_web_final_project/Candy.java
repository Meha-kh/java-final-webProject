package com.example.java_web_final_project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity

public class Candy {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String flavor;
    private double price;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flavor='" + flavor + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candy candy)) return false;
        return Double.compare(candy.getPrice(), getPrice()) == 0 && Objects.equals(getId(), candy.getId()) && Objects.equals(getName(), candy.getName()) && Objects.equals(getFlavor(), candy.getFlavor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFlavor(), getPrice());
    }
}
