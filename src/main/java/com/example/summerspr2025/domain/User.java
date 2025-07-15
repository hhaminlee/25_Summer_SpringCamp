package com.example.summerspr2025.domain;

import com.example.summerspr2025.dto.DefaultDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class User extends AuditingField{
    String title;
    String username; // spring 기본값
    String password; // spring 기본값
    String name;
    String phone;

    private User(String title, String username, String password, String name, String phone){
        this.title = title;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static User of(String title, String username, String password, String name, String phone){
        return new User(title, username, password, name, phone);
    }

    public DefaultDto.CreateResDto toCreateResDto(){
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
