package com.bilichenko.mvc.testshop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class DateTimeHandler {

    @ModelAttribute
    public void addTimeToModel(Model model) {
        model.addAttribute("dateTime", new Date());
    }
}