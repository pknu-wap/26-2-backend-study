package com.example.demo.board;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<Board> create(
            @RequestBody BoardRequest request
    ) {
        Board board = boardService.create(
                request.getTitle(),
                request.getContent()
        );

        return ResponseEntity.ok(board);
    }

    @GetMapping
    public ResponseEntity<List<Board>> findAll() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(boardService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> update(
            @PathVariable Long id,
            @RequestBody BoardRequest request
    ) {
        Board board = boardService.update(
                id,
                request.getTitle(),
                request.getContent()
        );

        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        boardService.delete(id);

        return ResponseEntity.ok().build();
    }
}