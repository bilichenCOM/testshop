package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.model.Cart;
import com.bilichenko.mvc.testshop.model.Product;
import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.CartService;
import com.bilichenko.mvc.testshop.service.ProductService;
import com.bilichenko.mvc.testshop.service.UserService;
import com.bilichenko.mvc.testshop.service.exceptions.CartNotFoundException;
import com.bilichenko.mvc.testshop.service.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart(Principal principal, ModelAndView mav) {
        mav.addObject("cart", getCartOfPrincipal(principal));
        mav.setViewName("cart");
        return mav;
    }

    @RequestMapping(value = "/cart/add/product", method = RequestMethod.GET)
    public ModelAndView addProductToCart(@RequestParam Long id, Principal principal, ModelAndView mav) {
        Cart cart = getCartOfPrincipal(principal);
        Product product = productService.getById(id)
                .orElseThrow(() -> new ProductNotFoundException());
        cart.addProduct(product);

        cartService.update(cart);
        mav.addObject("cartMessage",
                String.format("'%s' was successfully added to your cart!", product.getName()));
        mav.setViewName("redirect:/categories");
        return mav;
    }

    @RequestMapping(value = "/cart/remove/product", method = RequestMethod.GET)
    public ModelAndView removeProductFromCart(@RequestParam Long id, Principal principal, ModelAndView mav) {
        Cart cart = getCartOfPrincipal(principal);
        Product product = productService.getById(id)
                .orElseThrow(() -> new ProductNotFoundException());
        cart.removeProduct(product);

        cartService.update(cart);
        mav.addObject("cartMessage",
                String.format("'%s' was removed from your cart!", product.getName()));
        mav.setViewName("redirect:/cart");
        return mav;
    }

    private Cart getCartOfPrincipal(Principal principal) {
        User user = userService.getByEmail(principal.getName()).get();
        return cartService.getById(user.getCart().getId()).get();
    }
}