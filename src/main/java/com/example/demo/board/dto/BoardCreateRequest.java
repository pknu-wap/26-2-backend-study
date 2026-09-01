package com.example.demo.board.dto;

public record BoardCreateRequest(String title, String content) {
}
// 이 DTO는 Postman JSON의 title과 content를 담는 주문서임.
// id랑 createdAt는 서버가 만들기 때문에 DTO에 안 넣음.

