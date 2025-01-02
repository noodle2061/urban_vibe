package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.RatingDao;
import com.main.urban_vibe.entities.Rating;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RatingDaoImpl implements RatingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Rating> getList() {
        TypedQuery<Rating> query = entityManager.createQuery("SELECT r FROM Rating r", Rating.class);
        return query.getResultList();
    }

    @Override
    public Rating getById(Long id) {
        return entityManager.find(Rating.class, id);
    }

    @Override
    public Rating create(Rating rating) {
        entityManager.persist(rating);
        return rating;
    }

    @Override
    public Rating update(Rating rating) {
        return entityManager.merge(rating);
    }

    @Override
    public void delete(Long id) {
        Rating rating = getById(id);
        if (rating != null) {
            entityManager.remove(rating);
        }
    }

    @Override
    public List<Rating> getRatingsByProductId(Long productId) {
        TypedQuery<Rating> query = entityManager.createQuery("SELECT r FROM Rating r WHERE r.product.id = :productId", Rating.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        TypedQuery<Rating> query = entityManager.createQuery("SELECT r FROM Rating r WHERE r.user.id = :userId", Rating.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public Double getAverageRatingByProductId(Long productId) {
        TypedQuery<Double> query = entityManager.createQuery("SELECT AVG(r.rating) FROM Rating r WHERE r.product.id = :productId", Double.class);
        query.setParameter("productId", productId);
        return query.getSingleResult();
    }
}