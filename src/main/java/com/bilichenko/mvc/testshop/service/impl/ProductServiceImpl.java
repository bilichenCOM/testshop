package com.bilichenko.mvc.testshop.service.impl;

import com.bilichenko.mvc.testshop.dao.ProductRepository;
import com.bilichenko.mvc.testshop.model.Product;
import com.bilichenko.mvc.testshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
}