package com.kt.springbootstudy.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.springbootstudy.domain.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}