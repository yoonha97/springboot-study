package com.kt.springbootstudy.domain.comment.dto;

import com.kt.springbootstudy.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class CommentDto {
	private int id;
	private String content;

	public CommentDto(Comment comment) {
		this.id = comment.getId();
		this.content = comment.getContent();
	}
}
