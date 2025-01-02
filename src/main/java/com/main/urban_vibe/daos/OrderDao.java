package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Order;
import java.util.List;

public interface OrderDao {
    List<Order> getList();
    Order getById(Long id);
    Order create(Order order);
    Order update(Order order);
    void delete(Long id);

    List<Order> getOrdersByUserId(Long userId);
    List<Order> getOrdersByStatus(String status);
}