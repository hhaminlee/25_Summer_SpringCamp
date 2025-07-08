package com.example.summerspr2025.controller;

import com.example.summerspr2025.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostRestController {
    final PostService postService;
    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> param){
        return postService.create(param);
    }
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> param){
        return postService.update(param);
    }
    @RequestMapping("/delete")
    public Map<String, Object> delete(@RequestParam int id){
        return postService.delete(id);
    }

    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id){
        return postService.detail(id);
    }
    @RequestMapping("/list")
    public List<Map<String, Object>> list(){
        return postService.list();
    }
}
