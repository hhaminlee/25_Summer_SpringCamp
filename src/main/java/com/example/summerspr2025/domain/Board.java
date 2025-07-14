package com.example.summerspr2025.domain;

import com.example.summerspr2025.dto.DefaultDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@Entity
public class Board extends AuditingField{
    String title;
    String content;
    String author;

    protected Board(){}
    public Board(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 이 메소드를 통해서만 데이터를 생성할 수 있음 -> 객체 생성을 제한함
    public static Board of(String title, String content, String author){
        return new Board(title, content, author);
    }

    public DefaultDto.CreateResDto toCreateResDto(){
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
