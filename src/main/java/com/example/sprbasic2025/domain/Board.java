package com.example.sprbasic2025.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board extends AuditingField{
    String title;
    String content;
    String author;

    protected Board() {}
    private Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //이 메서드를 통해서만 데이터 생성
    public static Board of(String title, String content, String author) {
        return new Board(title, content, author);
    }
}
