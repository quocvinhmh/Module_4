package com.example.from_dang_ky.repostority;

import com.example.from_dang_ky.model.Use;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUseRepostority extends JpaRepository<Use, Long> {
    List<Use> searchUseByName(@NotBlank(message = "Name không được để trống") @Size(min = 5, max = 45, message = "Name phải từ 5 đến 45 ký tự") String name);
}
