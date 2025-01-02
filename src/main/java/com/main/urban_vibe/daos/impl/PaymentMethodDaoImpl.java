package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.PaymentMethodDao;
import com.main.urban_vibe.entities.PaymentMethod;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PaymentMethodDaoImpl implements PaymentMethodDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PaymentMethod> getList() {
        TypedQuery<PaymentMethod> query = entityManager.createQuery("SELECT pm FROM PaymentMethod pm", PaymentMethod.class);
        return query.getResultList();
    }

    @Override
    public PaymentMethod getById(Long id) {
        return entityManager.find(PaymentMethod.class, id);
    }

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        entityManager.persist(paymentMethod);
        return paymentMethod;
    }

    @Override
    public PaymentMethod update(PaymentMethod paymentMethod) {
        return entityManager.merge(paymentMethod);
    }

    @Override
    public void delete(Long id) {
        PaymentMethod paymentMethod = getById(id);
        if (paymentMethod != null) {
            entityManager.remove(paymentMethod);
        }
    }

    @Override
    public PaymentMethod findByName(String name) {
        TypedQuery<PaymentMethod> query = entityManager.createQuery("SELECT pm FROM PaymentMethod pm WHERE pm.name = :name", PaymentMethod.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}