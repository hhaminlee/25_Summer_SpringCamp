package com.example.summerspr2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// 어노테이션은 중요한 것들을 가장 밑으로 적용(정해진 포맷은 아님)
@RequestMapping("/board")
@Controller
public class BoardController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        // 리턴값에 있는 슬래시는 templates 폴더구조를 가리킴
        return "board/" + page;
    }
}
