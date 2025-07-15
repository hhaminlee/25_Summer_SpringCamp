package com.example.summerspr2025.dto;

import com.example.summerspr2025.domain.Board;
import com.example.summerspr2025.domain.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class UserDto {
    @Getter
    @Setter
    @Builder
    public static class CreateReqDto {
        String title;
        String username;
        String password;
        String name;
        String phone;

        // create 할 때 이외에는 사용하지 않기 때문에 명시함
        public User toEntity(){
            return User.of(getTitle(), getUsername(), getPassword(), getName(), getPhone());
        }
    }

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String title;
        String username;
        String password;
        String name;
        String phone;
    }
    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto{
        String title;
        String username;
        String password;
        String name;
        String phone;
    }
}
