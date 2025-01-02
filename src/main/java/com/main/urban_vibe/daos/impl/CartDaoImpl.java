package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.CartDao;
import com.main.urban_vibe.entities.Cart;
import com.main.urban_vibe.entities.CartOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cart> getList() {
        TypedQuery<Cart> query = entityManager.createQuery("SELECT c FROM Cart c", Cart.class);
        return query.getResultList();
    }

    @Override
    public Cart getById(Long id) {
        return entityManager.find(Cart.class, id);
    }

    @Override
    public Cart create(Cart cart) {
        entityManager.persist(cart);
        return cart;
    }

    @Override
    public Cart update(Cart cart) {
        return entityManager.merge(cart);
    }

    @Override
    public void delete(Long id) {
        Cart cart = getById(id);
        if (cart != null) {
            entityManager.remove(cart);
        }
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        TypedQuery<Cart> query = entityManager.createQuery("SELECT c FROM Cart c WHERE c.user.id = :userId", Cart.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    @Override
    public void clearCart(Long cartId) {
        Cart cart = getById(cartId);
        if (cart != null) {
            // Assuming Cart has a relationship with CartOrder
            for (CartOrder cartOrder : cart.getCartOrders()) {
                entityManager.remove(cartOrder);
            }
            cart.getCartOrders().clear(); // Clear the list after removing
        }
    }
}