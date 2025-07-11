package com.example.summerspr2025.controller;

import com.example.summerspr2025.domain.Board;
import com.example.summerspr2025.dto.BoardDto;
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
    public BoardDto.CreateResDto create(@RequestBody BoardDto.CreateReqDto param){
        return boardService.create(param);
    }
    @PutMapping("")
    public BoardDto.UpdateResDto update(@RequestBody BoardDto.UpdateReqDto param){
        return boardService.update(param);
    }
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody BoardDto.DeleteReqDto param){
        return boardService.delete(param);
    }

    @GetMapping("/detail/{id}")
    public BoardDto.DetailResDto detail(@PathVariable int id){
        return boardService.detail(id);
    }
    @GetMapping("/list")
    public List<BoardDto.ListResDto> list(){
        return boardService.list();
    }
}
