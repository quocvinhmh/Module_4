package com.example.pl_san_pham.service;

import com.example.pl_san_pham.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone 15 Pro Max", 32990000));
        products.add(new Product(2, "Samsung Galaxy S24", 25990000));
        products.add(new Product(3, "Macbook Air M2", 29990000));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Trả về bản sao để tránh bị sửa từ bên ngoài
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                return;
            }
        }
    }

    @Override
    public Product getProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
