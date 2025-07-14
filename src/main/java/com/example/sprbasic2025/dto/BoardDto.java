package com.example.sprbasic2025.dto;

import lombok.*;

public class BoardDto {
    @Getter @Setter @Builder
    public static class CreateReqDto {
        String title;
        String content;
        String author;
    }
    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }
    @Getter @Setter @Builder
    public static class UpdateReqDto {
        Long id;
        String title;
        String content;
        String author;
    }
    @Getter @Setter @Builder //@NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        String title;
        String content;
        String author;
    }

}
