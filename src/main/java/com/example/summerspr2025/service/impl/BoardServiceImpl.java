package com.example.summerspr2025.service.impl;

import com.example.summerspr2025.domain.Board;
import com.example.summerspr2025.dto.BoardDto;
import com.example.summerspr2025.repository.BoardRepository;
import com.example.summerspr2025.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;
    @Override
    public BoardDto.CreateResDto create(BoardDto.CreateReqDto param) {
        String title = param.getTitle();
        String content = param.getContent();
        String author = param.getAuthor();

        Board board = Board.of(title, content, author);
        board = boardRepository.save(board);

        return BoardDto.CreateResDto.builder().id(board.getId()).build();
    }

    @Override
    public BoardDto.UpdateResDto update(BoardDto.UpdateReqDto param) {
        long id = param.getId();

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data"));

        if(param.getTitle() != null){ board.setTitle(param.getTitle()); }
        if(param.getContent() != null){ board.setContent(param.getTitle()); }
        if(param.getAuthor() != null){ board.setAuthor(param.getAuthor()); }
        boardRepository.save(board);

        return BoardDto.UpdateResDto.builder()
                .id(param.getId())
                .title(param.getTitle())
                .content(param.getContent())
                .author(param.getAuthor())
                .build();
    }

    @Override
    public Map<String, Object> delete(BoardDto.DeleteReqDto param) {
        long id = param.getId();

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data"));
        boardRepository.delete(board);

        int code = 200;

        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", code);
        return map_result;
    }
    @Override
    public BoardDto.DetailResDto detail(long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data"));

        return BoardDto.DetailResDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .build();
    }

    @Override
    public List<BoardDto.ListResDto> list() {
        List<Board> list = boardRepository.findAll();
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("list", list);
        return list.stream().map(board -> BoardDto.ListResDto.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .author(board.getAuthor())
                        .build())
                .collect(Collectors.toList());
    }
}
