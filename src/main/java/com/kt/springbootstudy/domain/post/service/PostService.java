package com.kt.springbootstudy.domain.post.service;

import com.kt.springbootstudy.domain.post.dto.PostDto;
import com.kt.springbootstudy.domain.post.entity.Post;
import com.kt.springbootstudy.domain.post.repository.PostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;

	// 모든 글 조회
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		List<PostDto> postDtos = new ArrayList<>();
		for (Post post : posts) {
			postDtos.add(new PostDto(post));
		}
		return postDtos;
	}

	// 특정 글 조회
	public Optional<PostDto> getPostById(int id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isPresent()) {
			PostDto postDto = new PostDto(optionalPost.get());
			return Optional.of(postDto);
		} else {
			return Optional.empty();
		}
	}

	// 글 작성
	public PostDto addPost(Post post) {
		Post savedPost = postRepository.save(post);
		return new PostDto(savedPost);
	}

	// 글 수정
	@Transactional
	public Optional<PostDto> updatePost(int id, Post newPost) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isPresent()) {
			Post post = optionalPost.get();
			post.setTitle(newPost.getTitle());
			post.setContent(newPost.getContent());
			post.setAuthor(newPost.getAuthor());
			return Optional.of(new PostDto(post));
		} else {
			return Optional.empty();
		}
	}

	// 글 삭제
	public boolean deletePost(int id) {
		if (postRepository.existsById(id)) {
			postRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
