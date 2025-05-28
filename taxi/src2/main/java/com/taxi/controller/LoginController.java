package com.taxi.controller;

import com.taxi.model.Driver;
import com.taxi.model.Passenger;
import com.taxi.model.User;
import com.taxi.repository.DriverRepository;
import com.taxi.repository.PassengerRepository;
import com.taxi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByName(username);

        if (user != null && user.getPass().equals(password)) {
            if ("ADMIN".equals(user.getRole())) {
                List<Driver> drivers = driverRepository.findAll();
                model.addAttribute("drivers", drivers);
                return "drivers";
            } else if ("USER".equals(user.getRole())) {
                List<Passenger> passengers = passengerRepository.findAll();
                model.addAttribute("passengers", passengers);
                return "passengers";
            }
        }

        return "login";
    }
}
