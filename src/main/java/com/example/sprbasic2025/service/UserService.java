package com.example.sprbasic2025.service;

import com.example.sprbasic2025.dto.UserDto;
import com.example.sprbasic2025.dto.DefaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    DefaultDto.CreateResDto create(UserDto.CreateReqDto param);
    void update(UserDto.UpdateReqDto param);
    void delete(UserDto.UpdateReqDto param);
    UserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
}