package com.example.summerspr2025.controller;

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
    public Map<String, Object> create(@RequestBody Map<String, Object> param){
        return boardService.create(param);
    }
    @PutMapping("")
    public Map<String, Object> update(@RequestBody Map<String, Object> param){
        return boardService.update(param);
    }
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody Map<String, Object> param){
        return boardService.delete(param);
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id){
        return boardService.detail(id);
    }
    @GetMapping("/list")
    public Map<String, Object> list(){
        return boardService.list();
    }
}
