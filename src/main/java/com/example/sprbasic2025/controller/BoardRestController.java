package com.example.sprbasic2025.controller;

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
    public Map<String, Object> create(@RequestBody Map<String, Object> param){
        return boardService.create(param);
    }
    @PutMapping("")
    public Map<String, Object> update(@RequestBody Map<String, Object> param){
        return boardService.update(param);
    }
    @DeleteMapping ("")
    public Map<String, Object> delete(@RequestBody Map<String, Object> param){
        Long id = Long.parseLong(param.get("id").toString());
        return boardService.delete(id);
    }
    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable long id){
        return boardService.detail(id);
    }
    @RequestMapping("/list")
    public Map<String, Object> list(){
        return boardService.list();
    }

}