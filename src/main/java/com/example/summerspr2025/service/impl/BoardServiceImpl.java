package com.example.summerspr2025.service.impl;

import com.example.summerspr2025.domain.Board;
import com.example.summerspr2025.dto.BoardDto;
import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.repository.BoardRepository;
import com.example.summerspr2025.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;
    @Override
    public DefaultDto.CreateResDto create(BoardDto.CreateReqDto param) {
        return boardRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(BoardDto.UpdateReqDto param) {
        long id = param.getId();

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data"));
        if(param.getDeleted() != null){ board.setDeleted(param.getDeleted()); }
        if(param.getTitle() != null){ board.setTitle(param.getTitle()); }
        if(param.getContent() != null){ board.setContent(param.getTitle()); }
        if(param.getAuthor() != null){ board.setAuthor(param.getAuthor()); }
        boardRepository.save(board);
    }

    @Override
    public void delete(long id) {
//        long id = param.getId();
//
//        Board board = boardRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No data"));
//        board.setDeleted(true);
//        boardRepository.save(board);
//        boardRepository.delete(board); -> 완전 삭제

        update(BoardDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }

    public BoardDto.DetailResDto get(long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data"));

        return BoardDto.DetailResDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .deleted(board.getDeleted())
                .createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt())
                .build();
    }
    @Override
    public BoardDto.DetailResDto detail(long id) {
        return get(id);
    }

    @Override
    public List<BoardDto.DetailResDto> list() {
        List<Board> list = boardRepository.findAll();
        List<BoardDto.DetailResDto> res = new ArrayList<>();
        for(Board each: list){
            res.add(detail(each.getId()));
        }
        return res;
    }
}
