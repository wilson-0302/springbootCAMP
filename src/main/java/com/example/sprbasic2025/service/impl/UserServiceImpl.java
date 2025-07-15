package com.example.sprbasic2025.service.impl;

import com.example.sprbasic2025.domain.User;
import com.example.sprbasic2025.dto.UserDto;
import com.example.sprbasic2025.dto.DefaultDto;
import com.example.sprbasic2025.repository.UserRepository;
import com.example.sprbasic2025.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ user.setDeleted(param.getDeleted()); }
        if(param.getPassword() != null){ user.setPassword(param.getPassword()); }
        if(param.getName() != null){ user.setName(param.getName()); }
        if(param.getPhone() != null){ user.setPhone(param.getPhone()); }
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto.UpdateReqDto param) {
        update(UserDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public UserDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        return UserDto.DetailResDto.builder().id(user.getId())
                .deleted(user.getDeleted()).createdAt(user.getCreatedAt()).modifiedAt(user.getModifiedAt())
                .username(user.getUsername()).name(user.getName()).phone(user.getPhone())
                .build();
    }

    @Override
    public UserDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        List<UserDto.DetailResDto> resultList = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for(User each : list){
            boolean isSerached = true;
            if(param.getDeleted() != null){
                System.out.println("param.getDeleted() not null?");
                if(each.getDeleted() != param.getDeleted()){
                    isSerached = false;
                    System.out.println("param.getDeleted() false");
                }
            }
            if(param.getName() != null && !param.getName().isEmpty()){
                System.out.println("param.getName() not null?");
                if(!each.getName().contains(param.getName())){
                    isSerached = false;
                    System.out.println("param.getName() : " + isSerached);
                }
            }
            if(param.getPhone() != null && !param.getPhone().isEmpty()){
                System.out.println("param.getPhone() not null?");
                if(!each.getPhone().contains(param.getPhone())){
                    isSerached = false;
                    System.out.println("param.getPhone() : " + isSerached);
                }
            }
            if(isSerached){
                resultList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
            }
        }
        return resultList;
    }
}