package com.example.demo.board;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board create(String title, String content) {
        Board board = new Board(title, content);
        return boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "게시글을 찾을 수 없습니다."
                        ));
    }

    public Board update(Long id, String title, String content) {
        Board board = findById(id);
        board.update(title, content);

        return boardRepository.save(board);
    }

    public void delete(Long id) {
        Board board = findById(id);
        boardRepository.delete(board);
    }
}