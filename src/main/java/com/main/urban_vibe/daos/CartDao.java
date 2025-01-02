package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Cart;
import java.util.List;

public interface CartDao {
    List<Cart> getList();
    Cart getById(Long id);
    Cart create(Cart cart);
    Cart update(Cart cart);
    void delete(Long id);

    Cart getCartByUserId(Long userId); // Lấy giỏ hàng của user
    void clearCart(Long cartId); // Xóa tất cả sản phẩm trong giỏ hàng
}