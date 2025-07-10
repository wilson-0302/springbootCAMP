package com.example.sprbasic2025.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 자동으로 올라가게
    Long id;

    @Setter String title;
    @Setter String content;
    @Setter String author;

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
