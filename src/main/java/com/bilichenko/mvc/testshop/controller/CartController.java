package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart(Principal principal, ModelAndView mav) {
        User user = userService.getByEmail(principal.getName()).get();
        mav.addObject("cart", user.getCart());
        mav.setViewName("cart");
        return mav;
    }
}
