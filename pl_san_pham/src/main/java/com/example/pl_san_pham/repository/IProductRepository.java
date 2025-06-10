package com.example.pl_san_pham.repository;

import com.example.pl_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
    void addProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(int id , Product product);
    Product getProduct(int id);
}
