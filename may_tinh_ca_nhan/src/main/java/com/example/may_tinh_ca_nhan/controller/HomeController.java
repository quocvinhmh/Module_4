package com.example.may_tinh_ca_nhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping(value = "/")
  public String showForm(){
        return "index";
    }

    @PostMapping(value = "/calculate")
    public String calculate(@RequestParam double x, @RequestParam double y,@RequestParam String operator, Model model){
 double result = 0;
 switch (operator){
     case "+":
         result = x + y;
         break;
         case "-":
             result = x - y;
             break;
             case "*":
                 result = x * y;
                 break;
                 case "/":
                     result = x / y;
                     break;
                     default:
                         break;

 }
model.addAttribute("result", result);
 return "index";
    }
}
