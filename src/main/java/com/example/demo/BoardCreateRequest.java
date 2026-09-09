package com.example.demo;

public class BoardCreateRequest {
    private String title;
    private String content;

    // Getter와 Setter (값을 넣고 빼기 위해 필요합니다)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
