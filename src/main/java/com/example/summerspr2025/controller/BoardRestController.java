package com.example.summerspr2025.controller;

import com.example.summerspr2025.domain.Board;
import com.example.summerspr2025.dto.BoardDto;
import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {
    final BoardService boardService;
    @PostMapping("")
    public DefaultDto.CreateResDto create(@RequestBody BoardDto.CreateReqDto param){
        return boardService.create(param);
    }
    @PutMapping("")
    public void update(@RequestBody BoardDto.UpdateReqDto param){
        boardService.update(param);
    }
    @DeleteMapping("")
    public void delete(@RequestBody BoardDto.UpdateReqDto param){
        boardService.delete(param.getId());
    }

    @GetMapping("/detail/{id}")
    public BoardDto.DetailResDto detail(@PathVariable int id){
        return boardService.detail(id);
    }
    @GetMapping("/list")
    public List<BoardDto.DetailResDto> list(){
        return boardService.list();
    }
}
