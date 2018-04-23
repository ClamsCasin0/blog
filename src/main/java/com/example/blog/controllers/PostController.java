package com.example.blog.controllers;


import com.example.blog.models.Post;
import com.example.blog.models.PostDetails;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UsersRepository;
import com.example.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository ptDao;
    private final UsersRepository userDao;

    @Autowired
    public PostController(PostRepository ptDao, UsersRepository userDao) {
        this.ptDao = ptDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model viewAndmodel) {
        Iterable<Post> posts = ptDao.findAll();
        viewAndmodel.addAttribute("posts", posts);
//        model.addAttribute("posts", ptSvc.getAllPosts());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewAndmodel) {
//        model.addAttribute("post", ptSvc.getPost(id));
        Post post = ptDao.findOne(id);
        viewAndmodel.addAttribute("post", post);
        return "/posts/show";
    }


    @GetMapping("/posts/create")
    public String showCreateForm(Model viewmodel) {
        Post post = new Post();
        viewmodel.addAttribute("post", post);
        return "/posts/create";
    }



    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        post.setUser(userDao.findOne((long)3));
        ptDao.save(post);
        return "redirect:/posts";
    }

//    @PostMapping("/posts/create/details")
//    public String detailsPost(@ModelAttribute PostDetails postD) {
//        ptDao.save(postD);
//    }

    @GetMapping("posts/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        Post post = ptDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "/posts/edit";
    }



    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        ptDao.delete(id);
        return "redirect:/posts";
    }

    @PostMapping("/posts/edit")
    public String handleEdit(@ModelAttribute Post post){
        ptDao.save(post);
        return "redirect:/posts";

    }





}



