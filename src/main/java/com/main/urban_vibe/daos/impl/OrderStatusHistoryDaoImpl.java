package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.OrderStatusHistoryDao;
import com.main.urban_vibe.entities.OrderStatusHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class OrderStatusHistoryDaoImpl implements OrderStatusHistoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderStatusHistory> getList() {
        TypedQuery<OrderStatusHistory> query = entityManager.createQuery("SELECT osh FROM OrderStatusHistory osh", OrderStatusHistory.class);
        return query.getResultList();
    }

    @Override
    public OrderStatusHistory getById(Long id) {
        return entityManager.find(OrderStatusHistory.class, id);
    }

    @Override
    public OrderStatusHistory create(OrderStatusHistory orderStatusHistory) {
        entityManager.persist(orderStatusHistory);
        return orderStatusHistory;
    }

    @Override
    public OrderStatusHistory update(OrderStatusHistory orderStatusHistory) {
        return entityManager.merge(orderStatusHistory);
    }

    @Override
    public void delete(Long id) {
        OrderStatusHistory orderStatusHistory = getById(id);
        if (orderStatusHistory != null) {
            entityManager.remove(orderStatusHistory);
        }
    }

    @Override
    public List<OrderStatusHistory> getOrderStatusHistoriesByOrderId(Long orderId) {
        TypedQuery<OrderStatusHistory> query = entityManager.createQuery("SELECT osh FROM OrderStatusHistory osh WHERE osh.order.id = :orderId", OrderStatusHistory.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    @Override
    public OrderStatusHistory findLatestStatusByOrderId(Long orderId) {
        TypedQuery<OrderStatusHistory> query = entityManager.createQuery("SELECT osh FROM OrderStatusHistory osh WHERE osh.order.id = :orderId ORDER BY osh.changedAt DESC", OrderStatusHistory.class);
        query.setParameter("orderId", orderId);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}