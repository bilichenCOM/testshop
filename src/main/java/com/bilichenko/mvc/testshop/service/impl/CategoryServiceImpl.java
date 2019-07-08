package com.bilichenko.mvc.testshop.service.impl;

import com.bilichenko.mvc.testshop.dao.CategoryRepository;
import com.bilichenko.mvc.testshop.model.Category;
import com.bilichenko.mvc.testshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }
}
