package com.example.ung_dung_muon_sach.repostiroy;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  IBookRepostiroy extends JpaRepository<Book, Long> {
}
