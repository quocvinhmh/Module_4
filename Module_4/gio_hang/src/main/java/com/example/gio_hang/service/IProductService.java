package com.example.gio_hang.service;

import com.example.gio_hang.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getProducts();
    Optional<Product> getProduct(long id);
}
