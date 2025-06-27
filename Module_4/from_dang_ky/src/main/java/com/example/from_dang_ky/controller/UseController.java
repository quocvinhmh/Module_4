package com.example.from_dang_ky.controller;

import com.example.from_dang_ky.model.Use;
import com.example.from_dang_ky.service.UseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UseController {

    @Autowired
    private UseService useService;

    @GetMapping("/list")
    public String listuse(Model model) {
        model.addAttribute("uselist", useService.findall());
        return "use/list";
    }
    @GetMapping("/")
    public String showform(Model model) {
        model.addAttribute("useform", new Use());
        return "use/form";
    }
    @PostMapping("/submit")
    public String submit(@Valid @ModelAttribute("useform") Use use , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "use/form";
        }
        useService.save(use);
        return "redirect:/list";
    }
}
