package com.kt.springbootstudy.model;

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
}