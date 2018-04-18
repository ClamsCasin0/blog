package com.example.blog.models;


import javax.persistence.*;

//@Entity
//@Table(name = "posts")
public class Post {



//    @Column(nullable = false)
    private String title;
//    @Column(nullable = false)
    private String description;
//    @Id
//    @GeneratedValue
    private long id;


    public Post() {
    }

    public Post(String title, String description, long id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
