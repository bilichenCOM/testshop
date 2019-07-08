package com.bilichenko.mvc.testshop.service.scheduler;

import com.bilichenko.mvc.testshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DefaultScheduler {

    @Autowired
    private CategoryService categoryService;

    @Scheduled(initialDelay = 5000, fixedDelay = 7000)
    public void schedule() {

        ente99
                 
        categoryService.getAll().stream()
                .peek(System.out::println);
    }
}
