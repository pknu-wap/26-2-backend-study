package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 1. 게시글 생성
    public BoardResponse createBoard(BoardCreateRequest request) {
        Board board = new Board(request.getTitle(), request.getContent());
        Board savedBoard = boardRepository.save(board);
        return BoardResponse.from(savedBoard);
    }

    // 2. 단일 게시글 조회 (없는 ID 요청 시 404 예외 발생)
    public BoardResponse getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "ID가 " + id + "인 게시글을 찾을 수 없습니다."
                ));

        return BoardResponse.from(board);
    }
}