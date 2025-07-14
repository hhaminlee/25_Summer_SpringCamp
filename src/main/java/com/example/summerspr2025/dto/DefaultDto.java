package com.example.summerspr2025.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


public class DefaultDto {

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto {
        Long id;
        Boolean deleted;
    }

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;
    }
}
