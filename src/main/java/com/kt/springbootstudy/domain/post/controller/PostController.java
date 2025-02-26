package com.kt.springbootstudy.domain.post.controller;

import com.kt.springbootstudy.domain.post.dto.PostDto;
import com.kt.springbootstudy.domain.post.entity.Post;
import com.kt.springbootstudy.domain.post.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	// 모든 글 조회
	@GetMapping
	public List<PostDto> getAllPosts() {
		return postService.getAllPosts();
	}

	// 특정 글 조회
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable int id) {
		Optional<PostDto> optionalPostDto = postService.getPostById(id);
		if (optionalPostDto.isPresent()) {
			return ResponseEntity.ok(optionalPostDto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 글 작성
	@PostMapping
	public ResponseEntity<PostDto> addPost(@RequestBody Post post) {
		PostDto postDto = postService.addPost(post);
		return ResponseEntity.ok(postDto);
	}

	// 글 수정
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@PathVariable int id, @RequestBody Post post) {
		Optional<PostDto> optionalPostDto = postService.updatePost(id, post);
		if (optionalPostDto.isPresent()) {
			return ResponseEntity.ok(optionalPostDto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable int id) {
		boolean deleted = postService.deletePost(id);
		if (deleted) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
