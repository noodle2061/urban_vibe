package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.ShippingMethodDao;
import com.main.urban_vibe.entities.ShippingMethod;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ShippingMethodDaoImpl implements ShippingMethodDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ShippingMethod> getList() {
        TypedQuery<ShippingMethod> query = entityManager.createQuery("SELECT sm FROM ShippingMethod sm", ShippingMethod.class);
        return query.getResultList();
    }

    @Override
    public ShippingMethod getById(Long id) {
        return entityManager.find(ShippingMethod.class, id);
    }

    @Override
    public ShippingMethod create(ShippingMethod shippingMethod) {
        entityManager.persist(shippingMethod);
        return shippingMethod;
    }

    @Override
    public ShippingMethod update(ShippingMethod shippingMethod) {
        return entityManager.merge(shippingMethod);
    }

    @Override
    public void delete(Long id) {
        ShippingMethod shippingMethod = getById(id);
        if (shippingMethod != null) {
            entityManager.remove(shippingMethod);
        }
    }

    @Override
    public ShippingMethod findByName(String name) {
        TypedQuery<ShippingMethod> query = entityManager.createQuery("SELECT sm FROM ShippingMethod sm WHERE sm.name = :name", ShippingMethod.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}