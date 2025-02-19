package com.kt.springbootstudy.service;

import com.kt.springbootstudy.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	private List<Post> posts = new ArrayList<>();
	private int nextId = 1; // int 타입 ID 자동 증가

	// 모든 글 조회
	public List<Post> getAllPosts() {
		return posts;
	}

	// 특정 글 조회 (for 문 사용)
	public Post getPostById(int id) {
		for (Post post : posts) {
			if (post.getId() == id) {
				return post;
			}
		}
		return null; // ID가 없으면 null 반환
	}

	// 글 작성
	public Post addPost(Post post) {
		post.setId(nextId++);
		posts.add(post);
		return post;
	}

	// 글 수정
	public boolean updatePost(int id, Post newPost) {
		for (Post post : posts) {
			if (post.getId() == id) {
				post.setTitle(newPost.getTitle());
				post.setContent(newPost.getContent());
				post.setAuthor(newPost.getAuthor());
				return true;
			}
		}
		return false;
	}

	// 글 삭제 (for 문 사용)
	public boolean deletePost(int id) {
		for (int i = 0; i < posts.size(); i++) {
			if (posts.get(i).getId() == id) {
				posts.remove(i);
				return true;
			}
		}
		return false; // ID가 없으면 false 반환
	}
}
