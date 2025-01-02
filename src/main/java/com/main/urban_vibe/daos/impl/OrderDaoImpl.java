package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.OrderDao;
import com.main.urban_vibe.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> getList() {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    @Override
    public Order getById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public Order create(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order update(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public void delete(Long id) {
        Order order = getById(id);
        if (order != null) {
            entityManager.remove(order);
        }
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.user.id = :userId", Order.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.status = :status", Order.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}