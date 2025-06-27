package com.example.cau_hinh_hom_thu.controller;


import com.example.cau_hinh_hom_thu.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private Email email = new Email();
    @GetMapping(value = "/")
public String showForm(Model model) {
        model.addAttribute("setting", email);
        return "index";
}
    @PostMapping("/update")
    public String updateForm(@ModelAttribute("setting") Email email, Model model) {
        this.email = email;
        model.addAttribute("message", "Cập nhật thành công!");
        model.addAttribute("setting", email);
        return "updata";
    }


}
