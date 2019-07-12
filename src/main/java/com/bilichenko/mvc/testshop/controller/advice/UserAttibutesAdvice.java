package com.bilichenko.mvc.testshop.controller.advice;

import com.bilichenko.mvc.testshop.model.Cart;
import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.CartService;
import com.bilichenko.mvc.testshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class UserAttibutesAdvice {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @ModelAttribute("cart")
    private Cart getCartOfCurrentUser(Principal principal) {
        if (principal == null) { return new Cart(); }
        User user = userService.getByEmail(principal.getName()).get();
        return cartService.getById(user.getCart().getId()).get();
    }

    @ModelAttribute("user")
    private User getUser(Principal principal) {
        if (principal == null) { return new User(); }
        return userService.getByEmail(principal.getName()).get();
    }
}
