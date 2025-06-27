package com.example.ung_dung_muon_sach.controller;


import com.example.ung_dung_muon_sach.model.BorrowCode;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ung_dung_muon_sach.model.Book;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowCodeService borrowCodeService;
    @GetMapping
    public String showformbooklist(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "list";
    }
    @GetMapping("/borrow/{id}")
    public String showformborrowcode(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "borrow";
        }
        return "error";
    }
@PostMapping("/borrow")
    public String borrowbook(@RequestParam Long id, Model model) throws BookUnavailableException {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            Book book1 = book.get();
            if (book1.getQuantity() == 0 ){
                throw new BookUnavailableException("Sách đã hết, không thể mượn.");
            }
            bookService.decreaseQuantity(book1);
            BorrowCode borrowCode = borrowCodeService.createBorrowCode(book1);
            model.addAttribute("borrowCode", borrowCode.getCode());
            return "borrow_success";
        }
        return "error";
    }

    @GetMapping("/return")
    public String showReturnForm(){
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, Model model) throws BookUnavailableException {
        Optional<BorrowCode> codebook = borrowCodeService.getBorrowCode(code);
        if (codebook.isPresent()) {
            BorrowCode borrowCode = codebook.get();
            Book book = borrowCode.getBook();

            bookService.increaseQuantity(book);
            borrowCodeService.deleteBorrowCode(borrowCode);
            model.addAttribute("title", book.getTitle());
            return "return_success";
        }
        throw new  BookUnavailableException("mã mượn ko hợp lệ");
    }
}
