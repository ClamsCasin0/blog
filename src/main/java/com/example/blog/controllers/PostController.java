package com.example.blog.controllers;


import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UsersRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostController {

    private final PostRepository ptDao;
    private final UsersRepository userDao;

    public PostController(PostRepository ptDao, UsersRepository userDao) {
        this.ptDao = ptDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model viewAndmodel) {
        Iterable<Post> posts = ptDao.findAll();
        viewAndmodel.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewAndmodel) {
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


//FIC THIS
    @PostMapping("/posts/create")
    public String createPost(@Valid Post post, Errors validation, Model model) {

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "/posts/create";
        } else {
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(loggedInUser);
            ptDao.save(post);
            return "redirect:/posts";
        }
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

    @PostMapping("/posts/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Post post){
        Post originalPost = ptDao.findOne(id);
        originalPost.setTitle(post.getTitle());
        originalPost.setDescription(post.getDescription());
        ptDao.save(post);
        return "redirect:/posts";

    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        ptDao.delete(id);
        return "redirect:/posts";
    }







}



