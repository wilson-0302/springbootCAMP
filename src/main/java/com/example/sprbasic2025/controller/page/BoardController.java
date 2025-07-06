package com.example.sprbasic2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {
    /*
    @RequestMapping("/create")
    public String create() {
        return "board/create";
    }
    */

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/"+page;
    }
}