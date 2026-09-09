package com.example.demo.board.dto;

// PUT 요청으로 전달되는 JSON 데이터를 담는 DTO입니다.
public record BoardUpdateRequest(

        // 사용자가 수정할 새로운 게시글 제목입니다.
        String title,

        // 사용자가 수정할 새로운 게시글 내용입니다.
        String content
) {
}