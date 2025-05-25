package com.example.anh_viet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private static final String[][] dictionary = {
            {"hello", "xin chào"},
            {"bye", "tạm biệt"},
            {"car", "xe hơi"},
            {"technology", "công nghệ"},
            {"information", "thông tin"}
    };

    @GetMapping("/")
    public String showForm() {
        return "home"; // hiển thị trang nhập
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String word, Model model) {
        String result = "Không tìm thấy";

        for (String[] entry : dictionary) {
            if (entry[0].equalsIgnoreCase(word.trim())) {
                result = entry[1];
                break;
            }
        }

        model.addAttribute("result", result);
        return "home"; // render lại trên cùng trang
    }
}
