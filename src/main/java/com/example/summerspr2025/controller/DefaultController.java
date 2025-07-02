package com.example.summerspr2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    @RequestMapping("/aaa")
    // requestparam이 붙어있는 변수는 없으면 에러가 발생함
    public String aaa(String name, String phone, Model model){
        System.out.println("name: " + name);
        System.out.println("phone: " + phone);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        return "aaa";
    }

    // 두개 숫자 입력받은 후 더해주는 페이지 컨트롤러
    @RequestMapping("/add")
    public String add(int a, int b, Model model){
        int result = a+b;
        model.addAttribute("result", result);
        return "add";
    }

    // 배열도 가능하고, 이런식으로 입력했을 경우 모두 같은 주소를 가리킴
    @RequestMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }
    @RequestMapping("/add2")
    public String add2(int a, int b, Model model){

        return "add";
    }
}
