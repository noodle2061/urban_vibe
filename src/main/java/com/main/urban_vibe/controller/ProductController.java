package com.main.urban_vibe.controller;

import com.main.urban_vibe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<String> getProducts(@RequestBody String productRequest) {
        String response = productService.getProducts(productRequest); 
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody String productDto) {
        String response = productService.updateProduct(productDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody String productDto) {
        String response = productService.createProduct(productDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody String productDeleteRequest) {
        String response = productService.deleteProduct(productDeleteRequest); 
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductDetail(@PathVariable String id) {
        String response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
}