package com.example.from_dang_ky.service;

import com.example.from_dang_ky.model.Use;
import com.example.from_dang_ky.repostority.IUseRepostority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseService implements IUseService {
    @Autowired
    private IUseRepostority useRepostority;
    @Override
    public List<Use> findall() {
        return useRepostority.findAll();
    }

    @Override
    public List<Use> findbyname(String name) {
        return useRepostority.searchUseByName(name);
    }

    @Override
    public void save(Use use) {
        useRepostority.save(use);
    }
}
