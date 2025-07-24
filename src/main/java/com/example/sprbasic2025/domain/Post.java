package com.example.sprbasic2025.domain;

import com.example.sprbasic2025.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Post extends AuditingField{
    Long userId;
    @Column(nullable = false) String title;
    @Column(length = 4000) String content;
    String img;

    protected Post() {}
    private Post(Long userId, String title, String content, String img) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public static Post of(Long userId, String title, String content, String img) {
        return new Post(userId, title, content, img);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}