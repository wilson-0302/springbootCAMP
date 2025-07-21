package com.example.sprbasic2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginPageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "user/"+page;
    }
}