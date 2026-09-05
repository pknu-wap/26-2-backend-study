package com.example.demo.board;

import com.example.demo.board.dto.BoardCreateRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    // Service가 Repository를 사용할 수 있도록 보관.

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board create(BoardCreateRequest request) {
        Board board = new Board(request.title(), request.content());
        // DTO 주문서에서 title과 content를 꺼내 새 Board 객체를 만듬.
        return boardRepository.save(board);
        // Board를 H2에 저장.
        // 저장 과정에서 id가 생성되고, id가 포함된 Board가 돌아옴.
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
        // 저장된 게시글을 모두 가져옴.
    }

    // 전달받은 id와 같은 게시글 한 개를 찾음.
    public Board findOne(Long id) {

        // Repository에서 id로 게시글을 조회함.
        // 게시글이 없으면 404 Not Found 예외를 발생시킴.
        return boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "게시글을 찾을 수 없습니다."
                ));
    }
}

