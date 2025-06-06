package com.example.pl_san_pham.controller;

import com.example.pl_san_pham.model.Product;
import com.example.pl_san_pham.service.IProductService;
import com.example.pl_san_pham.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product.getId(), product);
        return "redirect:/home";
    }
}
