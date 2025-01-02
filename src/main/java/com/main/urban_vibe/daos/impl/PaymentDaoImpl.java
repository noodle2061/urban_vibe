package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.PaymentDao;
import com.main.urban_vibe.entities.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PaymentDaoImpl implements PaymentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Payment> getList() {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p", Payment.class);
        return query.getResultList();
    }

    @Override
    public Payment getById(Long id) {
        return entityManager.find(Payment.class, id);
    }

    @Override
    public Payment create(Payment payment) {
        entityManager.persist(payment);
        return payment;
    }

    @Override
    public Payment update(Payment payment) {
        return entityManager.merge(payment);
    }

    @Override
    public void delete(Long id) {
        Payment payment = getById(id);
        if (payment != null) {
            entityManager.remove(payment);
        }
    }

    @Override
    public List<Payment> getPaymentsByOrderId(Long orderId) {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p WHERE p.order.id = :orderId", Payment.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    @Override
    public List<Payment> getPaymentsByUserId(Long userId) {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p WHERE p.user.id = :userId", Payment.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Payment> getPaymentsByStatus(String status) {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p WHERE p.paymentStatus = :status", Payment.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}