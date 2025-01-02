package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.CategoryDao;
import com.main.urban_vibe.entities.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> getList() {
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }

    @Override
    public Category getById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public Category create(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        return entityManager.merge(category);
    }

    @Override
    public void delete(Long id) {
        Category category = getById(id);
        if (category != null) {
            entityManager.remove(category);
        }
    }

    @Override
    public Category findByName(String name) {
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Category> findByDescriptionContaining(String keyword) {
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c WHERE c.description LIKE :keyword", Category.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }
}