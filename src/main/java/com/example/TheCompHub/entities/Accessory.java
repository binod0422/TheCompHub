package com.example.TheCompHub.entities;

import jakarta.persistence.*;


@Entity
@Table(name="Accessory")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, updatable = false )
    private Integer id;

    @Column( nullable = false )
    private String name;
    //    @Column(name ="id", nullable = false, updatable = false )
    private String image;

    @Column(name ="Price" )
    private Double price;
    //    @Column(name ="id", nullable = false, updatable = false )
    private String description;

//    public Player(Integer id) {
//        this.id = id;
//    }

//    public Player(String name, Integer age, Double yearsOfExperience, Double rating) {
//        this.name = name;
//        this.age = age;
//        this.yearsOfExperience = yearsOfExperience;
//        this.rating = rating;
//    }

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
}
