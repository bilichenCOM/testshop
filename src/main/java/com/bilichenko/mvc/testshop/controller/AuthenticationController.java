package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

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
}
