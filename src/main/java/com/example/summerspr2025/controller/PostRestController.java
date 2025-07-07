package com.example.summerspr2025.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/api/post")
@RestController
public class PostRestController {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    int tempId = 0;
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> param){
        String title = (String) param.get("title");
        String content = (String) param.get("content");
        String author = (String) param.get("author");

        Map<String, Object> post = new HashMap<>();
        post.put("id", ++tempId);
        post.put("title", title);
        post.put("content", content);
        post.put("author", author);

        Map<String, Object> returnVal = new HashMap<>();
        returnVal.put("id", tempId);
        returnVal.put("code", 200);

        return post;
    }
    @GetMapping("/list")
    public List<Map<String, Object>> list(){
        return list;
    }

    public Map<String, Object> get(int id){
        for(Map<String, Object> each: list){
            int eachId = Integer.parseInt(each.get("id") + "");
            if(eachId == id){
                return each;
            }
        }
        return null;
    }
    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id){
        return get(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> param){
        int code = 0;

        int id = (int) param.get("id");
        Map<String, Object> tempPost = get(id);


        if(tempPost != null){
            String title = (String) param.get("title");
            String content = (String) param.get("content");
            String author = (String) param.get("author");
            tempPost.put("title", title);
            tempPost.put("content", content);
            tempPost.put("author", author);
        }

        return tempPost;
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(int id){
        Map<String, Object> tempPost = get(id);
        int code = 0;
        int tempI =-1;
        for(int i=0; i<list.size(); i++){
            if((int) list.get(i).get("id") == id){
                tempI = i;
            }
        }
        if(tempI != -1){
            code = 200;
            tempPost.remove(tempI);
        }
        Map<String, Object> returnVal = new HashMap<>();
        returnVal.put("code", code);
        return returnVal;
    }
}
