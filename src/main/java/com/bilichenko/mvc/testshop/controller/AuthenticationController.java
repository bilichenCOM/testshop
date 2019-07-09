package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin(ModelAndView mav) {
        mav.addObject("user", new User());
        mav.setViewName("signin");
        return mav;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(ModelAndView mav) {
        mav.addObject("user", new User());
        mav.setViewName("signup");
        return mav;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signin(@ModelAttribute User user, ModelAndView mav) {
        User dbUser = userService.save(user)
                .orElseThrow(() -> new UsernameNotFoundException("failed to save user"));
        dbUser.setPassword("");
        mav.addObject("user", dbUser);
        mav.setViewName("redirect:/signin");
        return mav;
    }
}
