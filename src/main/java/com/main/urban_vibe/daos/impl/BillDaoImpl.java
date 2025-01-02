package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.BillDao;
import com.main.urban_vibe.entities.Bill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BillDaoImpl implements BillDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Bill> getList() {
        TypedQuery<Bill> query = entityManager.createQuery("SELECT b FROM Bill b", Bill.class);
        return query.getResultList();
    }

    @Override
    public Bill getById(Long id) {
        return entityManager.find(Bill.class, id);
    }

    @Override
    public Bill create(Bill bill) {
        entityManager.persist(bill);
        return bill;
    }

    @Override
    public Bill update(Bill bill) {
        return entityManager.merge(bill);
    }

    @Override
    public void delete(Long id) {
        Bill bill = getById(id);
        if (bill != null) {
            entityManager.remove(bill);
        }
    }

    @Override
    public List<Bill> getBillsByUserId(Long userId) {
        TypedQuery<Bill> query = entityManager.createQuery("SELECT b FROM Bill b WHERE b.user.id = :userId", Bill.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Bill> getBillsByPaymentStatus(String paymentStatus) {
        TypedQuery<Bill> query = entityManager.createQuery("SELECT b FROM Bill b WHERE b.paymentStatus = :paymentStatus", Bill.class);
        query.setParameter("paymentStatus", paymentStatus);
        return query.getResultList();
    }
}