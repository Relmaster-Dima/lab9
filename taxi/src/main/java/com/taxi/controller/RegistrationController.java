package com.taxi.controller;

import com.taxi.entity.UserEntity;
import com.taxi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";    // src/main/resources/templates/register.html
    }

    @PostMapping("/register")
    public String processRegistration(
            @ModelAttribute("user") UserEntity user,
            Model model
    ) {
        try {
            userService.registerNewUser(
                    user.getName(),
                    user.getPass()
            );
            return "redirect:/login?registered";
        } catch (RuntimeException ex) {
            model.addAttribute("error", ex.getMessage());
            return "register";
        }
    }
}
