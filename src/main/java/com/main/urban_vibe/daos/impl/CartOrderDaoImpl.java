package com.main.urban_vibe.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.main.urban_vibe.daos.CartOrderDao;
import com.main.urban_vibe.entities.CartOrder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CartOrderDaoImpl implements CartOrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CartOrder> getList() {
        TypedQuery<CartOrder> query = entityManager.createQuery("SELECT co FROM CartOrder co", CartOrder.class);
        return query.getResultList();
    }

    @Override
    public CartOrder getById(Long id) {
        return entityManager.find(CartOrder.class, id);
    }

    @Override
    public CartOrder create(CartOrder cartOrder) {
        entityManager.persist(cartOrder);
        return cartOrder;
    }

    @Override
    public CartOrder update(CartOrder cartOrder) {
        return entityManager.merge(cartOrder);
    }

    @Override
    public void delete(Long id) {
        CartOrder cartOrder = getById(id);
        if (cartOrder != null) {
            entityManager.remove(cartOrder);
        }
    }

    @Override
    public List<CartOrder> getCartOrdersByCartId(Long cartId) {
        TypedQuery<CartOrder> query = entityManager.createQuery("SELECT co FROM CartOrder co WHERE co.cart.id = :cartId", CartOrder.class);
        query.setParameter("cartId", cartId);
        return query.getResultList();
    }

    @Override
    public List<CartOrder> getCartOrdersByOrderId(Long orderId) {
        TypedQuery<CartOrder> query = entityManager.createQuery("SELECT co FROM CartOrder co WHERE co.order.id = :orderId", CartOrder.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    @Override
    public void removeProductFromCart(Long cartId, Long productId) {
        TypedQuery<CartOrder> query = entityManager.createQuery(
                "SELECT co FROM CartOrder co WHERE co.cart.id = :cartId AND co.order.id IN " +
                        "(SELECT od.order.id FROM OrderDetail od WHERE od.product.id = :productId)",
                CartOrder.class);
        query.setParameter("cartId", cartId);
        query.setParameter("productId", productId);

        List<CartOrder> cartOrders = query.getResultList();
        for (CartOrder cartOrder : cartOrders) {
            entityManager.remove(cartOrder);
        }
    }

    @Override
    public CartOrder findByCartAndOrder(Long cartId, Long orderId) {
        TypedQuery<CartOrder> query = entityManager.createQuery(
                "SELECT co FROM CartOrder co WHERE co.cart.id = :cartId AND co.order.id = :orderId",
                CartOrder.class);
        query.setParameter("cartId", cartId);
        query.setParameter("orderId", orderId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}