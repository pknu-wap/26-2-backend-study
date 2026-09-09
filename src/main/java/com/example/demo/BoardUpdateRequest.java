package com.example.demo;

public class BoardUpdateRequest {

    private String title;
    private String content;

    public BoardUpdateRequest() {}

    public BoardUpdateRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}