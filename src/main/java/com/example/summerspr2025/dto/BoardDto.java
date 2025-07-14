package com.example.summerspr2025.dto;

import com.example.summerspr2025.domain.Board;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class BoardDto {
    @Getter @Setter @Builder
    public static class CreateReqDto {
        String title;
        String content;
        String author;

        public Board toEntity(){
            return Board.of(getTitle(), getContent(), getAuthor());
        }
    }

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String title;
        String content;
        String author;
    }
    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto{
        String title;
        String content;
        String author;
    }
}
