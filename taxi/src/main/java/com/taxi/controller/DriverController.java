package com.taxi.controller;

import com.taxi.entity.DriverEntity;
import com.taxi.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/drivers")
    public String showDrivers(Model model) {
        List<DriverEntity> drivers = driverRepository.findAllByDeletedFalse();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }

    @PostMapping("/drivers/add")
    public String addDriver(@RequestParam String name,
                            @RequestParam String phoneNumber,
                            @RequestParam(required = false) String email,
                            @RequestParam String licenseNumber,
                            RedirectAttributes redirectAttributes) {
        DriverEntity driver = new DriverEntity();
        driver.setName(name);
        driver.setPhoneNumber(phoneNumber);
        driver.setEmail(email);
        driver.setLicenseNumber(licenseNumber);
        driver.setDeleted(false);
        driverRepository.save(driver);
        return "redirect:/drivers";
    }

    @PostMapping("/drivers/edit/{id}")
    public String editDriver(@PathVariable("id") Long id,
                             @RequestParam String name,
                             @RequestParam String phoneNumber,
                             @RequestParam(required = false) String email,
                             @RequestParam String licenseNumber,
                             RedirectAttributes redirectAttributes) {
        DriverEntity driver = driverRepository.findById(id).orElse(null);
        if (driver != null) {
            driver.setName(name);
            driver.setPhoneNumber(phoneNumber);
            driver.setEmail(email);
            driver.setLicenseNumber(licenseNumber);
            driverRepository.save(driver);
        }
        return "redirect:/drivers";
    }

    @PostMapping("/drivers/delete/{id}")
    public String deleteDriver(@PathVariable("id") Long id) {
        DriverEntity driver = driverRepository.findById(id).orElse(null);
        if (driver != null) {
            driver.setDeleted(true);
            driverRepository.save(driver);
        }
        return "redirect:/drivers";
    }
}
