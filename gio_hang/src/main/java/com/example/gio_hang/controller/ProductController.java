package com.example.gio_hang.controller;

import com.example.gio_hang.model.CartItem;
import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showListProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String showProduct(Model model, @PathVariable int id) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product/show";
        } else {
            return "redirect:/products";
        }
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        Map<Integer, CartItem> cartItemMap = (Map<Integer, CartItem>) session.getAttribute("cartItemMap");
        if (cartItemMap == null) {
            cartItemMap = new HashMap<>();
        }
        model.addAttribute("cartItemMap", cartItemMap);
        model.addAttribute("total", calculateTotal(cartItemMap));
        return "product/cart";
    }

    private double calculateTotal(Map<Integer, CartItem> cartItemMap) {
        return cartItemMap.values().stream().mapToDouble(CartItem::getPrice).sum();
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/add/{id}")
    public String addProduct(HttpSession session, @PathVariable int id, @RequestParam int quantity) {
        Product product = productService.getProduct(id).orElse(null);
        if (product == null) {
            return "redirect:/products";
        }

        Map<Integer, CartItem> cartItemMap = (Map<Integer, CartItem>) session.getAttribute("cartItemMap");
        if (cartItemMap == null) {
            cartItemMap = new HashMap<>();
        }

        if (cartItemMap.containsKey(id)) {
            CartItem cartItem = cartItemMap.get(id);
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItemMap.put(id, new CartItem(product, quantity));
        }

        session.setAttribute("cartItemMap", cartItemMap);
        return "redirect:/cart";
    }
}
