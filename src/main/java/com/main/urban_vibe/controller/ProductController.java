package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @GetMapping
    public String getProducts(@RequestBody String x) {
        // No business logic, just return an empty list
        return x;
    }

    @PutMapping
    public String updateProduct(@RequestBody String productDto) {
        // No business logic, just return the received DTO
        return productDto;
    }

    @PostMapping
    public String createProduct(@RequestBody String productDto) {
        // No business logic, just return the received DTO
        return productDto;
    }

    @DeleteMapping
    public String deleteProduct(@RequestBody String productDto) {
        // No business logic, just return ok
        return productDto;
    }

    @GetMapping("/{id}")
    public String getProductDetail(@PathVariable Long id, @RequestBody String productVersion) {
        // No business logic, just return an empty object or a dummy product
        return productVersion;
    }
}