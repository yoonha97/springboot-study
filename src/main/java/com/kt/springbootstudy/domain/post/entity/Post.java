package com.kt.springbootstudy.domain.post.entity;

import java.util.ArrayList;
import java.util.List;

import com.kt.springbootstudy.domain.comment.entity.Comment;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID
    private int id;

    @Column(nullable = false)
    private String title; // 글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // 글 내용

    @Column(nullable = false)
    private String author; // 작성자

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    /*
     * @OneToMany(mappedBy = "post") → 게시글이 여러 개의 댓글을 가짐
     * cascade=CascadeType.ALL → 게시글 삭제 시 관련 댓글도 삭제
     * orphanRemoval=true → 댓글이 더 이상 참조되지 않으면 삭제
     */
}