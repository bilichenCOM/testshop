package com.bilichenko.mvc.testshop.dao;

import com.bilichenko.mvc.testshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
