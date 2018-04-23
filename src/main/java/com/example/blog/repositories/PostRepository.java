package com.example.blog.repositories;

import com.example.blog.models.Post;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import java.io.Serializable;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {


}
