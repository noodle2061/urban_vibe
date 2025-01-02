package com.main.urban_vibe.daos;

import java.util.List;

import com.main.urban_vibe.entities.CartOrder;

public interface CartOrderDao {
    List<CartOrder> getList();
    CartOrder getById(Long id);
    CartOrder create(CartOrder cartOrder);
    CartOrder update(CartOrder cartOrder);
    void delete(Long id);

    List<CartOrder> getCartOrdersByCartId(Long cartId);
    List<CartOrder> getCartOrdersByOrderId(Long orderId);
    void removeProductFromCart(Long cartId, Long productId); // Xóa sản phẩm khỏi cart
    CartOrder findByCartAndOrder(Long cartId, Long orderId); // Tìm kiếm theo cart và order
}