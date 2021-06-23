package com.example.demo.controller;

import com.example.demo.models.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class First_control {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main_package";
    }

    @GetMapping("/about")
    public String MainShop(Model model) {
        model.addAttribute("title", "About");
        return "blocks/about";
    }

}

