package com.example.summerspr2025.dto;

import lombok.*;

public class BoardDto {
    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateReqDto {
        String title;
        String content;
        String author;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
        String title;
        String content;
        String author;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto {
        Long id;
        String title;
        String content;
        String author;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateResDto {
        Long id;
        String title;
        String content;
        String author;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DeleteReqDto {
        Long id;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        String title;
        String content;
        String author;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class ListResDto {
        Long id;
        String title;
        String content;
        String author;
    }
}
