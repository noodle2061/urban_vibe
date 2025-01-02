package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.ProductTagDao;
import com.main.urban_vibe.entities.ProductTag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductTagDaoImpl implements ProductTagDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductTag> getList() {
        TypedQuery<ProductTag> query = entityManager.createQuery("SELECT pt FROM ProductTag pt", ProductTag.class);
        return query.getResultList();
    }

    @Override
    public ProductTag getById(Long id) {
        return entityManager.find(ProductTag.class, id);
    }

    @Override
    public ProductTag create(ProductTag productTag) {
        entityManager.persist(productTag);
        return productTag;
    }

    @Override
    public ProductTag update(ProductTag productTag) {
        return entityManager.merge(productTag);
    }

    @Override
    public void delete(Long id) {
        ProductTag productTag = getById(id);
        if (productTag != null) {
            entityManager.remove(productTag);
        }
    }

    @Override
    public List<ProductTag> getProductTagsByProductId(Long productId) {
        TypedQuery<ProductTag> query = entityManager.createQuery("SELECT pt FROM ProductTag pt WHERE pt.product.id = :productId", ProductTag.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    @Override
    public List<ProductTag> getProductTagsByTagId(Long tagId) {
        TypedQuery<ProductTag> query = entityManager.createQuery("SELECT pt FROM ProductTag pt WHERE pt.tag.id = :tagId", ProductTag.class);
        query.setParameter("tagId", tagId);
        return query.getResultList();
    }
}