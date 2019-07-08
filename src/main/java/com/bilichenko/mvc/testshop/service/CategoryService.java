package com.bilichenko.mvc.testshop.service;

import com.bilichenko.mvc.testshop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAll();

    Optional<Category> getById(Long id);
}
