package com.example.sprbasic2025.service;

import com.example.sprbasic2025.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BoardService {
    BoardDto.CreateResDto create(BoardDto.CreateReqDto param);
    void update(BoardDto.UpdateReqDto param);
    void delete(long id);
    BoardDto.DetailResDto detail(long id);
    List<BoardDto.DetailResDto> list();
}