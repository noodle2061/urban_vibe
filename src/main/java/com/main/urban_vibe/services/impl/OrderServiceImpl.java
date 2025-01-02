package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrders(String request) {
        return request;
    }

    @Override
    public String getOrderById(String request) {
        return request;
    }

    @Override
    public String createOrder(String request) {
        return request;
    }

    @Override
    public String updateOrder(String request) {
        return request;
    }
}