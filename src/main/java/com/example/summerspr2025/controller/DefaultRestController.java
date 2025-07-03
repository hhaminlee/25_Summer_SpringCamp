package com.example.summerspr2025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// restController는 사실상 controller + ResponseBody를 합친 것과 같음
@RestController
// 모든 메소드 주소 앞에 api를 붙여줌
@RequestMapping("/api")
public class DefaultRestController {
    @RequestMapping("/cal")
    public Map<String, Object> cal(int a, int b){
        Map<String, Object> map = new HashMap<>();
        map.put("sum", a+b);
        return map;
    }
    @RequestMapping("/mul")
    public Map<String, Object> mul(@RequestParam(value = "a", defaultValue = "1")Integer a,
                                   @RequestParam(value = "b", defaultValue = "1")Integer b){
        Map<String, Object> map = new HashMap<>();
        map.put("mul", a*b);
        return map;
    }
}
