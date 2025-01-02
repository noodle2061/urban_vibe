package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @PostMapping
    public String createOrder(@RequestBody String orderDto) {
        // No business logic, just return the received DTO
        return orderDto;
    }

    @GetMapping
    public String getOrders(@RequestBody String orderDto) {
        // No business logic, just return an empty list
        return orderDto;
    }

    @GetMapping("/{id}")
    public String getOrderDetail(@PathVariable String id) {
        // No business logic, just return an empty object
        return id;
    }

    @PutMapping
    public String updateOrder(@RequestBody String orderDto) {
        // No business logic, just return the received DTO
        return orderDto;
    }
}