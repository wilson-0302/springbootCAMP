package com.example.sprbasic2025.controller;

import com.example.sprbasic2025.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostRestController {
    final BoardService boardService;

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> param) {
        return boardService.create(param);
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        return boardService.list();
//        return list;
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id) {
        return boardService.detail(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> param) {
        return boardService.update(param);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(int id) {
        return boardService.delete(id);
    }
}