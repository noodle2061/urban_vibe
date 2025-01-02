package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.OrderStatusHistory;
import java.util.List;

public interface OrderStatusHistoryDao {
    List<OrderStatusHistory> getList();
    OrderStatusHistory getById(Long id);
    OrderStatusHistory create(OrderStatusHistory orderStatusHistory);
    OrderStatusHistory update(OrderStatusHistory orderStatusHistory);
    void delete(Long id);

    List<OrderStatusHistory> getOrderStatusHistoriesByOrderId(Long orderId);
    OrderStatusHistory findLatestStatusByOrderId(Long orderId);
}