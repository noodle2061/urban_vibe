package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.FeedbackDao;
import com.main.urban_vibe.entities.Feedback;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FeedbackDaoImpl implements FeedbackDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Feedback> getList() {
        TypedQuery<Feedback> query = entityManager.createQuery("SELECT f FROM Feedback f", Feedback.class);
        return query.getResultList();
    }

    @Override
    public Feedback getById(Long id) {
        return entityManager.find(Feedback.class, id);
    }

    @Override
    public Feedback create(Feedback feedback) {
        entityManager.persist(feedback);
        return feedback;
    }

    @Override
    public Feedback update(Feedback feedback) {
        return entityManager.merge(feedback);
    }

    @Override
    public void delete(Long id) {
        Feedback feedback = getById(id);
        if (feedback != null) {
            entityManager.remove(feedback);
        }
    }

    @Override
    public List<Feedback> getFeedbacksByProductId(Long productId) {
        TypedQuery<Feedback> query = entityManager.createQuery("SELECT f FROM Feedback f WHERE f.product.id = :productId", Feedback.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    @Override
    public List<Feedback> getFeedbacksByUserId(Long userId) {
        TypedQuery<Feedback> query = entityManager.createQuery("SELECT f FROM Feedback f WHERE f.user.id = :userId", Feedback.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Feedback> getFeedbacksByStatus(String status) {
        TypedQuery<Feedback> query = entityManager.createQuery("SELECT f FROM Feedback f WHERE f.status = :status", Feedback.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}