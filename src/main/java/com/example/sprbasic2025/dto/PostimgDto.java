package com.example.sprbasic2025.dto;

import com.example.sprbasic2025.domain.Postimg;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class PostimgDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long postId;
        String img;

        public Postimg toEntity(){
            return Postimg.of(getPostId(), getImg());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String img;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        Long postId;
        String img;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        Long postId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        Long postId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        Long postId;
    }
}
