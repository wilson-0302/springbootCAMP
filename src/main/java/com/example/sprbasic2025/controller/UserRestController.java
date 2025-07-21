package com.example.sprbasic2025.controller;

import com.example.sprbasic2025.dto.UserDto;
import com.example.sprbasic2025.dto.DefaultDto;
import com.example.sprbasic2025.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserRestController {

    final UserService userService;

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto param){
        return ResponseEntity.ok(userService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody UserDto.UpdateReqDto param){
        userService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody UserDto.UpdateReqDto param){
        userService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("")
    public ResponseEntity<UserDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(userService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResDto>> list(UserDto.ListReqDto param){
        return ResponseEntity.ok(userService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(UserDto.PagedListReqDto param){
        return ResponseEntity.ok(userService.pagedList(param));
    }
}