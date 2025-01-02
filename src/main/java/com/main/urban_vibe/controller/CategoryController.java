package com.main.urban_vibe.controller;

import com.main.urban_vibe.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<String> getCategories(@RequestBody String requestEntity) {
        String response = categoryService.getCategories(requestEntity); 
        return ResponseEntity.ok(response);
    }
}