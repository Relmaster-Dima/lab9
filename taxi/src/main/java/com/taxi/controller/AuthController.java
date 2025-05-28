package com.taxi.controller;

import com.taxi.exception.UserAlreadyExistsException;
import com.taxi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

  /*  @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/api/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        try {
            userService.registerNewUser(username, password);
            model.addAttribute("message", "Регистрация успешна! Можете войти.");
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("error", "Имя пользователя занято.");
        }
        return "register";
    }*/
}
