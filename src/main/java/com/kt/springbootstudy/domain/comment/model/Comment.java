package com.kt.springbootstudy.domain.comment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.kt.springbootstudy.domain.post.model.Post;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID
	private int id;

	@Column(nullable = false)
	private String content; // 댓글 내용

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false) // 외래키 설정
	private Post post;
}
