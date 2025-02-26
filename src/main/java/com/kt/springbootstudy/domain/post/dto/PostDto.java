package com.kt.springbootstudy.domain.post.dto;

import lombok.Getter;
import java.util.List;
import java.util.stream.Collectors;

import com.kt.springbootstudy.domain.comment.dto.CommentDto;
import com.kt.springbootstudy.domain.post.model.Post;

@Getter
public class PostDto {
	private int id;
	private String title;
	private String content;
	private List<CommentDto> comments;

	public PostDto(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.comments = post.getComments().stream().map(CommentDto::new).collect(Collectors.toList());
	}
}
