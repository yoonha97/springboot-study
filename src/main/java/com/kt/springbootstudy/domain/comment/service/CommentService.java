package com.kt.springbootstudy.domain.comment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kt.springbootstudy.domain.comment.dto.CommentDto;
import com.kt.springbootstudy.domain.comment.entity.Comment;
import com.kt.springbootstudy.domain.comment.repository.CommentRepository;
import com.kt.springbootstudy.domain.post.entity.Post;
import com.kt.springbootstudy.domain.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	// 댓글 작성
	public CommentDto addComment(int postId, Comment comment) {
		Optional<Post> optionalPost = postRepository.findById(postId);
		if (optionalPost.isPresent()) {
			comment.setPost(optionalPost.get());
			Comment savedComment = commentRepository.save(comment);
			return new CommentDto(savedComment);
		} else {
			throw new RuntimeException("Post not found");
		}
	}

	// 댓글 조회
	public List<CommentDto> getComments(int postId) {
		List<Comment> comments = commentRepository.findByPostId(postId);
		List<CommentDto> commentDtos = new ArrayList<>();
		for (Comment comment : comments) {
			commentDtos.add(new CommentDto(comment));
		}
		return commentDtos;
	}

	// 댓글 수정
	public Optional<CommentDto> updateComment(int commentId, Comment updatedComment) {
		Optional<Comment> optionalComment = commentRepository.findById(commentId);
		if (optionalComment.isPresent()) {
			Comment comment = optionalComment.get();
			comment.setContent(updatedComment.getContent());
			commentRepository.save(comment);
			return Optional.of(new CommentDto(comment));
		} else {
			return Optional.empty();
		}
	}

	// 댓글 삭제
	public boolean deleteComment(int commentId) {
		if (commentRepository.existsById(commentId)) {
			commentRepository.deleteById(commentId);
			return true;
		} else {
			return false;
		}
	}
}
