package com.kt.springbootstudy.domain.comment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kt.springbootstudy.domain.comment.dto.CommentDto;
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
	public ResponseEntity<CommentDto> addComment(@PathVariable int postId, @RequestBody Comment comment) {
		CommentDto commentDto = commentService.addComment(postId, comment);
		return ResponseEntity.ok(commentDto);
	}

	// 댓글 조회
	@GetMapping
	public List<CommentDto> getComments(@PathVariable int postId) {
		return commentService.getComments(postId);
	}

	// 댓글 수정
	@PutMapping("/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable int commentId, @RequestBody Comment updatedComment) {
		Optional<CommentDto> optionalCommentDto = commentService.updateComment(commentId, updatedComment);
		if (optionalCommentDto.isPresent()) {
			return ResponseEntity.ok(optionalCommentDto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 댓글 삭제
	@DeleteMapping("/{commentId}")
	public ResponseEntity<Void> deleteComment(@PathVariable int commentId) {
		boolean deleted = commentService.deleteComment(commentId);
		if (deleted) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
