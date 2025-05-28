package com.taxi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // после логина придём на "/", а потом сразу перенаправимся на /passengers
    @GetMapping("/")
    public String home() {
        return "redirect:/index";  // или "/drivers", если нужно
    }
}
