package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @PutMapping
    public String updateCart(@RequestBody String cartDto) {
        // No business logic, just return the received DTO
        return cartDto;
    }

    @GetMapping
    public String getCart(@RequestBody String cart) {
        // No business logic, just return an empty object
        return cart;
    }
}