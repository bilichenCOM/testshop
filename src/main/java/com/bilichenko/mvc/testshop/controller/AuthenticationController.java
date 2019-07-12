package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.controller.payloads.UserPayload;
import com.bilichenko.mvc.testshop.model.Cart;
import com.bilichenko.mvc.testshop.model.Role;
import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin(ModelAndView mav) {
        mav.addObject("user", new User());
        mav.setViewName("signin");
        return mav;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(ModelAndView mav) {
        mav.addObject("userPayload", new UserPayload());
        mav.setViewName("signup");
        return mav;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signin(@ModelAttribute("userPayload") @Valid UserPayload userPayload,
                               BindingResult bindingResult,
                               ModelAndView mav) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        User user = User.ofPayload(userPayload);
        user.setPassword(encoder.encode(userPayload.getFirstPassword()));
        user.setBalance(0.0);
        user.setCart(new Cart());
        user.addRole(Role.ofUser());

        userService.save(user);
        return "redirect:/signin";
    }
}