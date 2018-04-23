package com.example.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {


    @Id
    @GeneratedValue
//    @Column(columnDefinition = "UNSIGNED")
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;


    //Creates the relationship the users table
    @OneToOne
//    @JoinColumn(name = "user_id")
    private User user;
//
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;
//
    @OneToOne
    private PostDetails postDetails;

    //need to add to constructor/g/s/etters
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_categories",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Categories> categories;


    public Post() {
    }


    public Post(String title, String description, long id,  User user, PostDetails postD, List<PostImage> images, List<Categories> categories) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.id = id;
        this.postDetails = postD;
        this.categories = categories;
        this.images = images;
    }


    public Post(String title, String description, User user, PostDetails postD, List<PostImage> images, List<Categories> categories) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.postDetails = postD;
        this.categories = categories;
        this.images = images;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}
