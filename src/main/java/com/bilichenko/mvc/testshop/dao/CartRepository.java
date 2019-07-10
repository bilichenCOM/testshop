package com.bilichenko.mvc.testshop.dao;

import com.bilichenko.mvc.testshop.model.Cart;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @EntityGraph("Cart.products")
    Optional<Cart> findById(Long id);
}
