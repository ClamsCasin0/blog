package com.example.blog.repositories;

import com.example.blog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}