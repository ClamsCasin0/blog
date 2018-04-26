package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UsersRepository users;
    private PasswordEncoder passwordEncoder;

    public UserController(UsersRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        }

        @GetMapping("/register")
        public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/register";
        }

        @PostMapping("/register")
        public String registerUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
        }

        //FIX THIS
//        @GetMapping("/login")
//        public String showLoginForm() {
////        User loggedInUser = (User)
////                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return "users/login";
//        }
}
