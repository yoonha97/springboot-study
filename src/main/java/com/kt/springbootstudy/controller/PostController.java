package com.kt.springbootstudy.controller;

import com.kt.springbootstudy.model.Post;
import com.kt.springbootstudy.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	// 모든 글 조회
	@GetMapping
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	// 특정 글 조회
	@GetMapping("/{id}")
	public Optional<Post> getPostById(@PathVariable int id) {
		return postService.getPostById(id);
	}

	// 글 작성
	@PostMapping
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}

	// 글 수정
	@PutMapping("/{id}")
	public String updatePost(@PathVariable int id, @RequestBody Post post) {
		boolean updated = postService.updatePost(id, post);
		return updated ? "Post updated successfully" : "Post not found";
	}

	// 글 삭제
	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable int id) {
		boolean deleted = postService.deletePost(id);
		return deleted ? "Post deleted successfully" : "Post not found";
	}
}