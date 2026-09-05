package com.example.demo.board;

import com.example.demo.board.dto.BoardCreateRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/boards")
// 이 클래스가 /boards API 요청을 받는다는 뜻.
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // POST/boards 요청을 받고, 성고하면 201 Created 상태 코드를 돌려줌.
    public Board create(@RequestBody BoardCreateRequest request) {
        // Postman body의 JSON을 BoardCreateRequest DTO에 담음
        return boardService.create(request);
        // 실제 생성 처리는 Service에 맡김.
    }

    // GET /boards 요청이 들어오면 아래 findAll 메서드를 실행함.
    @GetMapping
    public List<Board> findAll() {
        return boardService.findAll();
    }

    // GET /boards/{id} 요청이 들어오면 아래 메서드를 실행함.
    @GetMapping("/{id}")
    public Board findOne(@PathVariable("id") Long id) {

        // URL에서 받은 id를 Service의 단건 조회 메서드에 전달함.
        // Service가 돌려준 게시글 한 개를 사용자에게 JSON으로 반환함.
        return boardService.findOne(id);
    }
}

