package com.example.blog.services;

import com.example.blog.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(long id) {
        return posts.get(((int) id) - 1);
    }

    public void createPosts() {
        // create some ad objects
        this.save(new Post("Test Title 1", "This is the test post description 1."));
        this.save(new Post("Test Title 2", "This is the test post description 2."));
        this.save(new Post("Test Title 3", "This is the test post description 3."));
        this.save(new Post("Test Title 4", "This is the test post description 4."));
        //add them to the ads list with the save method

    }

//    public Post save(Post post) {
//        post.setId(posts.size() + 1);
//        posts.add(post);
//        return post;
//    }

     public void save(Post post) {
        post.setId(this.posts.size() + 1);
        this.posts.add(post);
    }

//    public Post edit(Post post) {
//        posts.post.getId;
//        posts.add(post);
//        return post;
//
//    }


}






