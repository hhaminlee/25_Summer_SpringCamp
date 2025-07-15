package com.example.summerspr2025.service.impl;

import com.example.summerspr2025.domain.User;
import com.example.summerspr2025.dto.DefaultDto;
import com.example.summerspr2025.dto.UserDto;
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
    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        long id = param.getId();

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data"));
        if(param.getDeleted() != null){user.setDeleted(true);}
        if(param.getTitle() != null){user.setTitle(param.getTitle());}
        if(param.getUsername() != null){user.setUsername(param.getUsername());}
        if(param.getPassword() != null){user.setPassword(param.getPassword());}
        if(param.getName() != null){user.setName(param.getName());}
        if(param.getPhone() != null){user.setPhone(param.getPhone());}

        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        update(UserDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }

    public UserDto.DetailResDto get(long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data"));
        return UserDto.DetailResDto.builder()
                .id(user.getId())
                .title(user.getTitle())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .deleted(user.getDeleted())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .build();
    }

    @Override
    public UserDto.DetailResDto detail(long id) {
        return get(id);
    }

    @Override
    public List<UserDto.DetailResDto> list() {
        List<User> list = userRepository.findAll();
        List<UserDto.DetailResDto> returnResult = new ArrayList<>();

        for(User each: list){
            returnResult.add(detail(each.getId()));
        }
        return returnResult;
    }
}
