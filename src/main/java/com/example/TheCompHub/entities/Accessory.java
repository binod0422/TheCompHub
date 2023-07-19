package com.example.TheCompHub.entities;

import jakarta.persistence.*;


@Entity
//@Table(name="Accessory")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;




    private String name;

    @Column(columnDefinition = "LONGTEXT")
    private String image;

    private Double price;
    //    @Column(name ="id", nullable = false, updatable = false )
    private String description;

    private String category;

    public Accessory() {

    }

    public Accessory(String name, String image, Double price, String description, String category) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
