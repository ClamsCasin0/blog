package com.example.blog.services;

import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    //inject Daos repos here
//    @Autowired
    private final PostRepository ptDao;

//    private List<Post> posts;

    public PostService(PostRepository ptDao) {
        this.ptDao = ptDao;
//        this.posts = new ArrayList<>();
//        createPosts();
    }

    // note that we don't need separate insert and update methods.
    // the save method is smart enough to figure out which it needs to do
    // i.e. if the passed object already has an `id` property, update an
    // existing record, if it does not, insert a new record
    public Post save(Post post) {
        ptDao.save(post);
        return ptDao.findOne(post.getId());
    }

    // we'll need to define the return type as `Iterable` as that is
    // what the CrudRepository defines. You can think of `Iterable` as
    // an even more generic list, it is still a collection of items
    public Iterable<Post> findAll() {
        return ptDao.findAll();
    }

    public Post findOne(long id) {
        return ptDao.findOne(id);
    }

    public void delete(long id) {
        ptDao.delete(id);
    }
//    public List<Post> getAllPosts() {
//        return posts;
//    }

//    public Post getPost(long id) {
//        return posts.get(((int) id) - 1);
//    }

//    public void createPosts() {
//         create some ad objects
//        this.save(new Post("Test Title 1", "This is the test post description 1."));
//        this.save(new Post("Test Title 2", "This is the test post description 2."));
//        this.save(new Post("Test Title 3", "This is the test post description 3."));
//        this.save(new Post("Test Title 4", "This is the test post description 4."));
//        add them to the ads list with the save method
//
//    }

//    public Post save(Post post) {
//        post.setId(posts.size() + 1);
//        posts.add(post);
//        return post;
//    }

//     public void save(Post post) {
//        post.setId(this.posts.size() + 1);
//        this.posts.add(post);
//    }

    public Post edit(Post post) {
        ptDao.save(post);
        return post;

    }


}






