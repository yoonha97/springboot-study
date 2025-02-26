package com.kt.springbootstudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kt.springbootstudy.model.Comment;
import com.kt.springbootstudy.model.Post;
import com.kt.springbootstudy.repository.CommentRepository;
import com.kt.springbootstudy.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	// 댓글 작성
	public Comment addComment(int postId, Comment comment) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new RuntimeException("Post not found"));
		comment.setPost(post);
		return commentRepository.save(comment);
	}

	// 댓글 조회
	public List<Comment> getComments(int postId) {
		return commentRepository.findByPostId(postId);
	}

	// 댓글 수정
	public Optional<Comment> updateComment(int commentId, Comment updatedComment) {
		return commentRepository.findById(commentId)
				.map(comment -> {
					comment.setContent(updatedComment.getContent());
					return commentRepository.save(comment);
				});
	}

	// 댓글 삭제
	public boolean deleteComment(int commentId) {
		if (commentRepository.existsById(commentId)) {
			commentRepository.deleteById(commentId);
			return true;
		}
		return false;
	}
}