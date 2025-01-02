package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.InvoiceDao;
import com.main.urban_vibe.entities.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class InvoiceDaoImpl implements InvoiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Invoice> getList() {
        TypedQuery<Invoice> query = entityManager.createQuery("SELECT i FROM Invoice i", Invoice.class);
        return query.getResultList();
    }

    @Override
    public Invoice getById(Long id) {
        return entityManager.find(Invoice.class, id);
    }

    @Override
    public Invoice create(Invoice invoice) {
        entityManager.persist(invoice);
        return invoice;
    }

    @Override
    public Invoice update(Invoice invoice) {
        return entityManager.merge(invoice);
    }

    @Override
    public void delete(Long id) {
        Invoice invoice = getById(id);
        if (invoice != null) {
            entityManager.remove(invoice);
        }
    }

    @Override
    public List<Invoice> getInvoicesByUserId(Long userId) {
        TypedQuery<Invoice> query = entityManager.createQuery("SELECT i FROM Invoice i WHERE i.user.id = :userId", Invoice.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public Invoice findByInvoiceNumber(String invoiceNumber) {
        TypedQuery<Invoice> query = entityManager.createQuery("SELECT i FROM Invoice i WHERE i.invoiceNumber = :invoiceNumber", Invoice.class);
        query.setParameter("invoiceNumber", invoiceNumber);
        return query.getSingleResult();
    }
}