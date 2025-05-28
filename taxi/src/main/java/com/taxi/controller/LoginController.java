package com.taxi.controller;

import com.taxi.entity.UserEntity;
import com.taxi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    /*@GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }*/

    /*@PostMapping("/register")
    public String register(@ModelAttribute("user") UserEntity user, Model model) {
        if (userRepository.findByName(user.getName()) != null) {
            model.addAttribute("error", "Пользователь с таким именем уже существует.");
            return "register";
        }
        // Сохраняем пароль «как есть»
        user.setRole("User");
        userRepository.save(user);
        return "redirect:/login";
    }*/
}
