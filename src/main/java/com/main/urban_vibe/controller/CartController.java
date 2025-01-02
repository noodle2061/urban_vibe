package com.main.urban_vibe.controller;

import com.main.urban_vibe.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping
    public ResponseEntity<String> updateCart(@RequestBody String cartDto) {
        String response = cartService.updateCart(cartDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<String> getCart(@RequestBody String entityRequest) {
        String response = cartService.getCart(entityRequest); 
        return ResponseEntity.ok(response);
    }
}