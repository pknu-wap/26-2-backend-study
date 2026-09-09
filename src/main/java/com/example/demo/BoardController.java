package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 1. 게시글 생성
    @PostMapping
    public BoardResponse createBoard(@RequestBody BoardCreateRequest request) {
        return boardService.createBoard(request);
    }

    // 2. 단일 조회
    @GetMapping("/{id}")
    public BoardResponse getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    // 3. 전체 목록 조회
    @GetMapping
    public List<BoardResponse> getAllBoards() {
        return boardService.getAllBoards();
    }

    // 4. 게시글 수정
    @PutMapping("/{id}")
    public BoardResponse updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequest request) {
        return boardService.updateBoard(id, request);
    }

    // 5. 게시글 삭제 (200 OK + 문자열 반환)
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "게시글이 삭제되었습니다.";
    }
}