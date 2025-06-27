package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();
    Page<Blog> findAll(Pageable pageable);

    Blog findByid(long id);
    void saveBlog(Blog blog);
    void deleteBlog(long id);
    List<Blog> findBlogByTitle(String keyword);
    List<Blog> findByCategoryId(Long categoryId);
}
