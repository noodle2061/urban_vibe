package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.OrderDetailDao;
import com.main.urban_vibe.entities.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class OrderDetailDaoImpl implements OrderDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderDetail> getList() {
        TypedQuery<OrderDetail> query = entityManager.createQuery("SELECT od FROM OrderDetail od", OrderDetail.class);
        return query.getResultList();
    }

    @Override
    public OrderDetail getById(Long id) {
        return entityManager.find(OrderDetail.class, id);
    }

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        entityManager.persist(orderDetail);
        return orderDetail;
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        return entityManager.merge(orderDetail);
    }

    @Override
    public void delete(Long id) {
        OrderDetail orderDetail = getById(id);
        if (orderDetail != null) {
            entityManager.remove(orderDetail);
        }
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        TypedQuery<OrderDetail> query = entityManager.createQuery("SELECT od FROM OrderDetail od WHERE od.order.id = :orderId", OrderDetail.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    @Override
    public List<OrderDetail> getOrderDetailsByProductId(Long productId) {
        TypedQuery<OrderDetail> query = entityManager.createQuery("SELECT od FROM OrderDetail od WHERE od.product.id = :productId", OrderDetail.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }
}