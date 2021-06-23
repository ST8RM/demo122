package com.example.demo.controller;

import com.example.demo.models.Host;
import com.example.demo.controller.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Site_controller {
    @Autowired
    private HostRepository host_reposit;

    @GetMapping("/about")
    public String MainShop(Model model) {
        Iterable<Host> hosts = host_reposit.findAll();
        model.addAttribute("posts", hosts);
        return "shop_Main";
    }
}
