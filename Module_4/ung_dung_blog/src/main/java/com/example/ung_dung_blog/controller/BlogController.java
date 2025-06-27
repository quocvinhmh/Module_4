package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.IBlogService;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String listBlogs(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page, 5)); // 5 là số bài trên mỗi trang
        model.addAttribute("blogPage", blogPage);
        return "blog/list";
    }


    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findByid(id));
        return "blog/view";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findByid(id));
        model.addAttribute("categories", categoryService.getAllCategory());
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "redirect:/blogs";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, @RequestParam(defaultValue = "0") int page, Model model) {
        List<Blog> blogs = blogService.findBlogByTitle(keyword);
        Page<Blog> blogPage = new PageImpl<>(blogs, PageRequest.of(page, blogs.size() == 0 ? 1 : blogs.size()), blogs.size());
        model.addAttribute("blogPage", blogPage);
        return "blog/list";
    }

    @GetMapping("/category/{id}")
    public String viewByCategory(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, Model model) {
        List<Blog> blogs = blogService.findByCategoryId(id);
        Page<Blog> blogPage = new PageImpl<>(blogs, PageRequest.of(page, blogs.size() == 0 ? 1 : blogs.size()), blogs.size());
        model.addAttribute("blogPage", blogPage);
        return "blog/list";
    }
}