package com.example.gio_hang.repository;

import com.example.gio_hang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
