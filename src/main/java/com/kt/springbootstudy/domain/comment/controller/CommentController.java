package com.kt.springbootstudy.domain.comment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.springbootstudy.domain.comment.entity.Comment;
import com.kt.springbootstudy.domain.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;

	// 댓글 작성
	@PostMapping
	public ResponseEntity<Comment> addComment(@PathVariable int postId, @RequestBody Comment comment) {
		return ResponseEntity.ok(commentService.addComment(postId, comment));
	}

	// 댓글 조회
	@GetMapping
	public List<Comment> getComments(@PathVariable int postId) {
		return commentService.getComments(postId);
	}

	// 댓글 수정
	@PutMapping("/{commentId}")
	public ResponseEntity<Comment> updateComment(@PathVariable int commentId, @RequestBody Comment updatedComment) {
		return commentService.updateComment(commentId, updatedComment)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	// 댓글 삭제
	@DeleteMapping("/{commentId}")
	public ResponseEntity<Void> deleteComment(@PathVariable int commentId) {
		boolean deleted = commentService.deleteComment(commentId);
		return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}
