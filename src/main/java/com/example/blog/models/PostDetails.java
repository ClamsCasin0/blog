package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private double price;

    @Column
    private String location;


    public PostDetails() {
    }

    public PostDetails(double price, String location, long id) {
        this.id = id;
        this.price = price;
        this.location = location;
    }

    public PostDetails(double price, String location) {
        this.price = price;
        this.location = location;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
