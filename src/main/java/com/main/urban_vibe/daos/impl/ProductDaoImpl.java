package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.ProductDao;
import com.main.urban_vibe.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getList() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product create(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public void delete(Long id) {
        Product product = getById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    public List<Product> findByNameContaining(String keyword) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.name LIKE :keyword", Product.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.category.id = :categoryId", Product.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice", Product.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        return query.getResultList();
    }

    @Override
    public List<Product> findByAverageRatingGreaterThanEqual(double rating) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.averageRating >= :rating", Product.class);
        query.setParameter("rating", rating);
        return query.getResultList();
    }
}