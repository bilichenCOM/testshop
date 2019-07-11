package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.model.Cart;
import com.bilichenko.mvc.testshop.model.Product;
import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.CartService;
import com.bilichenko.mvc.testshop.service.ProductService;
import com.bilichenko.mvc.testshop.service.UserService;
import com.bilichenko.mvc.testshop.service.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    private Cart getCartOfPrincipal(Principal principal) {
        User user = userService.getByEmail(principal.getName()).get();
        return cartService.getById(user.getCart().getId()).get();
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart(@ModelAttribute Cart cart, ModelAndView mav) {
        mav.addObject("cart", cart);
        mav.setViewName("cart");
        return mav;
    }

    @RequestMapping(value = "/cart/add/product", method = RequestMethod.GET)
    public ModelAndView addProductToCart(@RequestParam("product_id") Long productId,
                                         @ModelAttribute Cart cart, ModelAndView mav,
                                         RedirectAttributes redirectAttributes) {
        Product product = productService.getById(productId)
                .orElseThrow(() -> new ProductNotFoundException());
        cart.addProduct(product);

        cartService.update(cart);
        redirectAttributes.addFlashAttribute("cartMessage",
                String.format("'%s' was successfully added to your cart!", product.getName()));
        mav.setViewName("redirect:/categories");
        return mav;
    }

    @RequestMapping(value = "/cart/remove/product", method = RequestMethod.GET)
    public ModelAndView removeProductFromCart(@RequestParam("product_id") Long productId,
                                              @ModelAttribute Cart cart, ModelAndView mav,
                                              RedirectAttributes redirectAttributes) {
        Product product = productService.getById(productId)
                .orElseThrow(() -> new ProductNotFoundException());
        cart.removeProduct(product);

        cartService.update(cart);
        redirectAttributes.addFlashAttribute("cartMessage",
                String.format("'%s' was removed from your cart!", product.getName()));
        mav.setViewName("redirect:/cart");
        return mav;
    }
}