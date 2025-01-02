package com.main.urban_vibe.services;

public interface OrderService {
    String getOrders(String request);
    String getOrderById(String request);
    String createOrder(String request);
    String updateOrder(String request);
}