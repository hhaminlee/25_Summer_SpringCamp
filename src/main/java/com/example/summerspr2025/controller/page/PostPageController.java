package com.example.summerspr2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/post")
@Controller
public class PostPageController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "post/" + page;
    }
}
