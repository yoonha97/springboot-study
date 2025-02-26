package com.kt.springbootstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.springbootstudy.domain.post.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}