package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.model.Category;
import com.bilichenko.mvc.testshop.model.Product;
import com.bilichenko.mvc.testshop.service.CategoryService;
import com.bilichenko.mvc.testshop.service.ProductService;
import com.bilichenko.mvc.testshop.service.exceptions.CategoryNotFoundException;
import com.bilichenko.mvc.testshop.service.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryAndProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

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

    @RequestMapping(value = "/categories/category/product")
    public ModelAndView productById(@RequestParam Long id, ModelAndView mav) {
        Product product = productService.getById(id).
                orElseThrow(() -> new ProductNotFoundException());
        mav.addObject("product", product);
        mav.addObject("category", getCategoryOfProduct(product));
        mav.setViewName("product");
        return mav;
    }

    private Category getCategoryOfProduct(Product product) {
        Long categoryId = product.getCategory().getId();
        return categoryService.getById(categoryId).get();
    }
}