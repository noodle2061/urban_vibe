package com.main.urban_vibe.controller;

import com.main.urban_vibe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody String orderDto) {
        String response = orderService.createOrder(orderDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<String> getOrders(@RequestBody String entityRequest) {
        String response = orderService.getOrders(entityRequest); 
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderDetail(@PathVariable String id) {
        String response = orderService.getOrderById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<String> updateOrder(@RequestBody String orderDto) {
        String response = orderService.updateOrder(orderDto);
        return ResponseEntity.ok(response);
    }
}