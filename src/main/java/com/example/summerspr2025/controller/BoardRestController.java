package com.example.summerspr2025.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {
    List<Map<String, Object>> list = new ArrayList<>();
    int temp = 0;
    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> param){

        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        Map<String, Object> map_board = new HashMap<>();
        map_board.put("id", ++temp);
        map_board.put("title", title);
        map_board.put("content", content);
        map_board.put("author", author);
        list.add(map_board);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("total size",list.size());

        return map;
    }

    @RequestMapping("/list")
    public Map<String, Object> list(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("total size", list.size());
        map.put("list", list);
        return map;
    }

    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id){
        Map<String, Object> map_board = new HashMap<>();
        for(Map<String, Object> each: list){
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId == id){
                map_board = each;
            }
        }

        int resultCode = 0;
        if(map_board != null){
            resultCode = 200;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", resultCode);
        map.put("total size", list.size());
        map.put("list", list);
        return map;
    }
}
