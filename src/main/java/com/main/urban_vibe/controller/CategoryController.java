package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @GetMapping
    public String getCategories(@RequestBody String category) {
        // No business logic, just return an empty list
        return category;
    }
}