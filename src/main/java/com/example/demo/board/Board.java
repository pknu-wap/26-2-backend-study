package com.example.demo.board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity // 이 클래스가 H2에 저장될 데이터 모양이라고 JPA에게 알려줌.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id가 게시글을 구분하는 번호이고, H2가 1,2,3처럼 자동으로 생성하도록 함.
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;

    protected Board() {
    }
    // JPA가 DB 데이터를 Board 객체로 만들 때, 사용하는 빈 생성자임.

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }
    // 사용자가 보낸 title과 content로 게시글을 만듬.
    // LocalDateTime.now()가 위 상황의 현재 시간을 읽어 createdAt에 넣음.

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}