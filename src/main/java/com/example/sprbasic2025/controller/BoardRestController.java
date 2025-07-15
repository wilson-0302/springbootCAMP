package com.example.sprbasic2025.controller;

import com.example.sprbasic2025.dto.BoardDto;
import com.example.sprbasic2025.dto.DefaultDto;
import com.example.sprbasic2025.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    final BoardService boardService;

    @PostMapping("")
    public DefaultDto.CreateResDto create(@RequestBody BoardDto.CreateReqDto param){
        return boardService.create(param);
    }
    @PutMapping("")
    public void update(@RequestBody BoardDto.UpdateReqDto param){
        boardService.update(param);
    }
    @DeleteMapping ("")
    public void delete(@RequestBody BoardDto.UpdateReqDto param){
        boardService.delete(param.getId());
    }
    @GetMapping("/detail/{id}")
    public BoardDto.DetailResDto detail(@PathVariable long id){
        return boardService.detail(id);
    }
    @RequestMapping("/list")
    public List<BoardDto.DetailResDto> list(){
        return boardService.list();
    }

}