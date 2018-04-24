package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.repositories.UsersRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UsersRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UsersRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        }

        @GetMapping("/sign-up")
        public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/sign-up";
        }

        @PostMapping("/sign-up")
        public String registerUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
        }

        @GetMapping("/login")
        public String showLoginForm() {
        User loggedInUser = (User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "users/login";
        }
}
