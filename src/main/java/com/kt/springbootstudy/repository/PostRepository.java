package com.kt.springbootstudy.repository;

import com.kt.springbootstudy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}