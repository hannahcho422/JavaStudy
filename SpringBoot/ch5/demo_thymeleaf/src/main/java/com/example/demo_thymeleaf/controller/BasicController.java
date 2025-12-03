package com.example.demo_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BasicController {
    @GetMapping("/book")
    public String getBook(Model model) {
        model.addAttribute("title", "스프링 부트");
        model.addAttribute("description", "Thymeleaf example");
        return "basic/book";
    }   
}
