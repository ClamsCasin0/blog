package com.example.blog.controllers;

import com.example.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {
    @GetMapping("/posts/index")
    public String Posts(Model model) {
        List<String> posts = new ArrayList<>();

        posts.add("First Post");
        posts.add("Second Post");
        posts.add("Third Post");

        model.addAttribute("posts", posts);
        return "index";
        }

    @GetMapping("/posts/show/{id}")
    @ResponseBody
    public String show(@PathVariable long id){
        return "viewing individual post#: " + id + "!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "viewing the Post create form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert(){
        return "created a new post!";
    }



}
