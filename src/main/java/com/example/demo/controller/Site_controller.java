package com.example.demo.controller;

import com.example.demo.models.Host;
import com.example.demo.controller.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class Site_controller {
    @Autowired
    private HostRepository HostRepository;


    @GetMapping("/last_news")
    public String News(Model model) {
        Iterable<Host> host = HostRepository.findAll();
        model.addAttribute("hosts", host);
        return ("Last_News");

    }

    @GetMapping("/last_news/add")
    public String Newsadd(Model model) {
        return ("News_Add");
    }

    @PostMapping("/last_news/add")
    public String NewsPostadd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Host host = new Host(title, anons, full_text);
        HostRepository.save(host);
        return "redirect:/last_news";
    }

    @GetMapping("/last_news/{id}")
    public String NewsInfo(@PathVariable(value = "id") long id, Model model) {
        Optional<Host> post = HostRepository.findById(id);
        ArrayList<Host> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return ("News_Details");
    }

    @GetMapping("/last_news/{id}/edit")
    public String NewsEdit(@PathVariable(value = "id") long id, Model model) {
        Optional<Host> post = HostRepository.findById(id);
        ArrayList<Host> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return ("News_Edit");
    }
    @PostMapping("/last_news/{id}/edit")
    public String NewsPostUPD(@PathVariable (value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Host host = HostRepository.findById(id).orElseThrow();
        host.setTitle(title);
        host.setAnons(anons);
        host.setFull_text(full_text);
        HostRepository.save(host);
        return "redirect:/last_news";
    }
    @PostMapping("/last_news/{id}/delete")
    public String NewsPostdel(@PathVariable (value = "id") long id, Model model) {
        Host host = HostRepository.findById(id).orElseThrow();
        HostRepository.delete(host);
        return "redirect:/last_news";
    }

}