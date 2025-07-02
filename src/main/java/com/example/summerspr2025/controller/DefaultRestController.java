package com.example.summerspr2025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// restController는 사실상 controller + ResponseBody를 합친 것과 같음
@RestController
public class DefaultRestController {
    @RequestMapping("/api/cal")
    public Map<String, Object> cal(int a, int b){
        Map<String, Object> map = new HashMap<>();
        map.put("sum", a+b);
        return map;
    }
}
