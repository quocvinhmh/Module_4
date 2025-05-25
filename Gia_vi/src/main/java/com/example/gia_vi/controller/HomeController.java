package com.example.gia_vi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String showhome() {
        return "index";
    }

    @PostMapping("/home")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "home";
    }
}
