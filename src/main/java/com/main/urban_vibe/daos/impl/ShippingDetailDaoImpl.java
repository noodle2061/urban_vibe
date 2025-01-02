package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.ShippingDetailDao;
import com.main.urban_vibe.entities.ShippingDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ShippingDetailDaoImpl implements ShippingDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ShippingDetail> getList() {
        TypedQuery<ShippingDetail> query = entityManager.createQuery("SELECT sd FROM ShippingDetail sd", ShippingDetail.class);
        return query.getResultList();
    }

    @Override
    public ShippingDetail getById(Long id) {
        return entityManager.find(ShippingDetail.class, id);
    }

    @Override
    public ShippingDetail create(ShippingDetail shippingDetail) {
        entityManager.persist(shippingDetail);
        return shippingDetail;
    }

    @Override
    public ShippingDetail update(ShippingDetail shippingDetail) {
        return entityManager.merge(shippingDetail);
    }

    @Override
    public void delete(Long id) {
        ShippingDetail shippingDetail = getById(id);
        if (shippingDetail != null) {
            entityManager.remove(shippingDetail);
        }
    }

    @Override
    public List<ShippingDetail> getShippingDetailsByOrderId(Long orderId) {
        TypedQuery<ShippingDetail> query = entityManager.createQuery("SELECT sd FROM ShippingDetail sd WHERE sd.order.id = :orderId", ShippingDetail.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }
}