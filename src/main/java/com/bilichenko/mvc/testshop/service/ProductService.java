package com.bilichenko.mvc.testshop.service;

import com.bilichenko.mvc.testshop.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getById(Long id);
}
