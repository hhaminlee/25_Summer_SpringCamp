package com.example.summerspr2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "user/" + page;
    }
    @RequestMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "user/"+page;
    }
}
