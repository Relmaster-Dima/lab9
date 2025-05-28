package com.taxi.controller;

import com.taxi.entity.PassengerEntity;
import com.taxi.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PassengerController {

    private final PassengerRepository passengerRepository;

    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping("/passengers")
    public String listPassengers(Model model) {
        List<PassengerEntity> passengers = passengerRepository.findAllByDeletedFalse();
        model.addAttribute("passengers", passengers);
        return "passengers";
    }

    @PostMapping("/passengers/add")
    public String addPassenger(@RequestParam String name,
                               @RequestParam String phoneNumber,
                               @RequestParam(required = false) String email,
                               RedirectAttributes redirectAttributes) {
        PassengerEntity passenger = new PassengerEntity();
        passenger.setName(name);
        passenger.setPhoneNumber(phoneNumber);
        passenger.setEmail(email);
        passenger.setDeleted(false);
        passengerRepository.save(passenger);
        return "redirect:/passengers";
    }

    @PostMapping("/passengers/edit/{id}")
    public String editPassenger(@PathVariable("id") Long id,
                                @RequestParam String name,
                                @RequestParam String phoneNumber,
                                @RequestParam(required = false) String email,
                                RedirectAttributes redirectAttributes) {
        PassengerEntity passenger = passengerRepository.findById(id).orElse(null);
        if (passenger != null) {
            passenger.setName(name);
            passenger.setPhoneNumber(phoneNumber);
            passenger.setEmail(email);
            passengerRepository.save(passenger);
        }
        return "redirect:/passengers";
    }

    @PostMapping("/passengers/delete/{id}")
    public String deletePassenger(@PathVariable("id") Long id) {
        PassengerEntity passenger = passengerRepository.findById(id).orElse(null);
        if (passenger != null) {
            passenger.setDeleted(true);
            passengerRepository.save(passenger);
        }
        return "redirect:/passengers";
    }
}
