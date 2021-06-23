package com.example.demo.controller;

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

    @GetMapping("/last_news")
    public String about(Model model) {
        model.addAttribute("title", "Последние новости");
        return "templates/last_news";
    }

    @GetMapping("/WiewMore")
    public String WiewMore(Model model) {
        model.addAttribute("title", "Подробнее");
        return "WiewMore";
    }
}
