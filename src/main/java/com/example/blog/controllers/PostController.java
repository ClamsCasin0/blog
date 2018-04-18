package com.example.blog.controllers;


import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    PostService ptSvc;

    public PostController(PostService ptSvc) {
        this.ptSvc = ptSvc;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", ptSvc.getAllPosts());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", ptSvc.getPost(id));
        return "/posts/show";
    }

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String create() {
//        return "Here is the post create form...";
//    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model viewmodel) {
        viewmodel.addAttribute("newPost", new Post());
        return "/posts/create";
    }

//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String insert() {
//        return "Inserted new post!";
//    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost) {
        ptSvc.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", ptSvc.getPost(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String handleEdit(@ModelAttribute Post post){
        System.out.println("post = " + post.getId());
        System.out.println("post = " + post.getDescription());
        System.out.println("post = " + post.getTitle());
        return "redirect:/posts";

    }



}



