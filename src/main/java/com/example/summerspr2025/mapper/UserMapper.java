package com.example.summerspr2025.mapper;

import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.dto.UserDto;

import java.util.List;

public interface UserMapper {
    //상세 조회를 위한 것
    UserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    //목록을 위한 것!
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    List<UserDto.DetailResDto> pagedList(UserDto.PagedListReqDto param);
    int pagedListCount(UserDto.PagedListReqDto param);
}
