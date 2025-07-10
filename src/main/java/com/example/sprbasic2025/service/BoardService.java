package com.example.sprbasic2025.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public interface BoardService {
    Map<String, Object> create(Map<String, Object> param);
    Map<String, Object> update(Map<String, Object> param);
    Map<String, Object> delete(long id);
    Map<String, Object> detail(long id);
    Map<String, Object> list();
}