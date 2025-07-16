package com.example.summerspr2025.controller;

import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.dto.UserDto;
import com.example.summerspr2025.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserRestController {
    final UserService userService;
    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto param){
        return ResponseEntity.ok(userService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody UserDto.UpdateReqDto param){
        userService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody UserDto.UpdateReqDto param){
        userService.delete(param.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<UserDto.DetailResDto> detail(@PathVariable int id){
        return ResponseEntity.ok(userService.detail(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResDto>> list(){
        return ResponseEntity.ok(userService.list());
    }
}
