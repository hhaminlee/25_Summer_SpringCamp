package com.example.summerspr2025.service.impl;

import com.example.summerspr2025.domain.User;
import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.dto.UserDto;
import com.example.summerspr2025.mapper.UserMapper;
import com.example.summerspr2025.repository.UserRepository;
import com.example.summerspr2025.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final UserMapper userMapper;

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ user.setDeleted(param.getDeleted()); }
        if(param.getPassword() != null){ user.setPassword(param.getPassword()); }
        if(param.getName() != null){ user.setName(param.getName()); }
        if(param.getPhone() != null){ user.setPhone(param.getPhone()); }
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto.UpdateReqDto param) {
        update(UserDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public UserDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        return userMapper.detail(param);
    }

    @Override
    public UserDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        return addList(userMapper.list(param));
    }

    public List<UserDto.DetailResDto> addList(List<UserDto.DetailResDto> list) {
        List<UserDto.DetailResDto> returnList = new ArrayList<>();
        for(UserDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param){
        DefaultDto.PagedListResDto res = param.init(userMapper.pagedListCount(param));
        res.setList(addList(userMapper.pagedList(param)));
        return res;
    }
    @Override
    public List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param) {
        param.init();
        return addList(userMapper.scrollList(param));
    }
}
