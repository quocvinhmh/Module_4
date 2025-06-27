package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(long id);
    Category addCategory(Category category);
    void deleteCategory(long id);
}
