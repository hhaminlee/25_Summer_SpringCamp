package com.example.summerspr2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DefaultController {
    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                System.out.println(i*j);
            }
            System.out.println();
        }
        return "test";
    }

    @ResponseBody
    @RequestMapping("/javareview1")
    public Map<String, Object> javareview1(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", "111");
        map.put("2", "222");
        map.remove("a");

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list.get(2));
        return map;
    }
}
