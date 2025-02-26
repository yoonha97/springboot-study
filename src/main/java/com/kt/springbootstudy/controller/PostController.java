package com.kt.springbootstudy.controller;

import com.kt.springbootstudy.domain.post.model.Post;
import com.kt.springbootstudy.service.PostService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	// 모든 글 조회
	@GetMapping
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	// 특정 글 조회
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable int id) {
		return postService.getPostById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	// 글 작성
	@PostMapping
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}

	// 글 수정
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePost(@PathVariable int id, @RequestBody Post post) {
		boolean updated = postService.updatePost(id, post);
		return updated ? ResponseEntity.ok("Post updated successfully") : ResponseEntity.notFound().build();
	}

	// 글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable int id) {
		boolean deleted = postService.deletePost(id);
		return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}