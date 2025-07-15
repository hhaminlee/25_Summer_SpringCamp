package com.example.summerspr2025.controller;

import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.dto.UserDto;
import com.example.summerspr2025.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserRestController {
    final UserService userService;
    @PostMapping("")
    public DefaultDto.CreateResDto create(@RequestBody UserDto.CreateReqDto param){
        return userService.create(param);
    }
    @PutMapping("")
    public void update(@RequestBody UserDto.UpdateReqDto param){
        userService.update(param);
    }
    @DeleteMapping("")
    public void delete(@RequestBody UserDto.UpdateReqDto param){
        userService.delete(param.getId());
    }

    @GetMapping("/detail/{id}")
    public UserDto.DetailResDto detail(@PathVariable int id){
        return userService.detail(id);
    }
    @GetMapping("/list")
    public List<UserDto.DetailResDto> list(){
        return userService.list();
    }
}
