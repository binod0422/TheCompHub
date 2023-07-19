package com.example.TheCompHub.entities;

import jakarta.persistence.*;

@Entity
public class NewArrivals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(columnDefinition = "LONGTEXT")
    String image;

    String name;
    String description;

    Integer price;

    String category;

    public NewArrivals() {
    }

    public NewArrivals(Integer id, String image, String name, String description, Integer price, String category) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

