package com.bilichenko.mvc.testshop.service.impl;

import com.bilichenko.mvc.testshop.dao.CartRepository;
import com.bilichenko.mvc.testshop.model.Cart;
import com.bilichenko.mvc.testshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Optional<Cart> getById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void update(Cart cart) {
        cartRepository.save(cart);
    }
}