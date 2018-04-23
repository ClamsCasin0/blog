package com.example.blog.controllers;

import com.example.blog.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UsersRepository userDao;
    private PasswordEncoder passwordEncoder;

}
