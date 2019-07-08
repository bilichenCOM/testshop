package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.service.CategoryService;
import com.bilichenko.mvc.testshop.service.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView categories(ModelAndView mav) {
        mav.addObject("categories", categoryService.getAll());
        mav.setViewName("categories");
        return mav;
    }

    @RequestMapping(value = "/categories/category", method = RequestMethod.GET)
    public ModelAndView categoryById(@RequestParam Long id, ModelAndView mav) {
        mav.addObject("category", categoryService.getById(id)
            .orElseThrow(() -> new CategoryNotFoundException()));
        mav.setViewName("category");
        return mav;
    }
}