package com.bilichenko.mvc.testshop.service;

import com.bilichenko.mvc.testshop.model.Cart;

import java.util.Optional;

public interface CartService {

    Optional<Cart> getById(Long id);

    void update(Cart cart);
}
