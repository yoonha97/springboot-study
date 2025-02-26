package com.kt.springbootstudy.service;

import com.kt.springbootstudy.model.Post;
import com.kt.springbootstudy.repository.PostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;

	// 모든 글 조회
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	// 특정 글 조회
	public Optional<Post> getPostById(int id) {
		return postRepository.findById(id);
	}

	// 글 작성
	public Post addPost(Post post) {
		return postRepository.save(post);
	}

	// 글 수정
	@Transactional
	public boolean updatePost(int id, Post newPost) {
		return postRepository.findById(id)
				.map(post -> {
					post.setTitle(newPost.getTitle());
					post.setContent(newPost.getContent());
					post.setAuthor(newPost.getAuthor());
					// save() 호출 불필요 (Dirty Checking)
					return true;
				}).orElse(false);
	}

	// 글 삭제
	public boolean deletePost(int id) {
		if (postRepository.existsById(id)) {
			postRepository.deleteById(id);
			return true;
		}
		return false;
	}
}