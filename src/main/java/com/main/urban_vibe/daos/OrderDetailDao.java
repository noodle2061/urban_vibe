package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.OrderDetail;
import java.util.List;

public interface OrderDetailDao {
    List<OrderDetail> getList();
    OrderDetail getById(Long id);
    OrderDetail create(OrderDetail orderDetail);
    OrderDetail update(OrderDetail orderDetail);
    void delete(Long id);

    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
    List<OrderDetail> getOrderDetailsByProductId(Long productId);
}