package com.example.from_dang_ky.service;

import com.example.from_dang_ky.model.Use;

import java.util.List;

public interface IUseService {
    List<Use> findall();
    List<Use> findbyname(String name);
    void save(Use use);

}
