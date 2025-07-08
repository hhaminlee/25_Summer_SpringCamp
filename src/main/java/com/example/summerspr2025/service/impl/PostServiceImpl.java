package com.example.summerspr2025.service.impl;

import com.example.summerspr2025.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    int tempId = 0;
    @Override
    public Map<String, Object> create(@RequestParam Map<String, Object> param){
        String title = (String) param.get("title");
        String content = (String) param.get("content");
        String author = (String) param.get("author");

        Map<String, Object> post = new HashMap<>();
        post.put("id", ++tempId);
        post.put("title", title);
        post.put("content", content);
        post.put("author", author);
        list.add(post);

        Map<String, Object> returnVal = new HashMap<>();
        returnVal.put("id", tempId);
        returnVal.put("code", 200);

        return post;
    }
    @Override
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
    @Override
    public Map<String, Object> detail(@PathVariable int id){
        return get(id);
    }

    @Override
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
    @Override
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
