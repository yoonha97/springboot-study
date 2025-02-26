package com.kt.springbootstudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.springbootstudy.domain.comment.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByPostId(int postId);
}
