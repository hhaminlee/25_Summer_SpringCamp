package com.example.summerspr2025.service;

import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    DefaultDto.CreateResDto create(UserDto.CreateReqDto param);
    void update(UserDto.UpdateReqDto param);
    void delete(long id);
    UserDto.DetailResDto detail(long id);
    List<UserDto.DetailResDto> list();
}
