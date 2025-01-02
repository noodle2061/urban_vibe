package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.ProductImageDao;
import com.main.urban_vibe.entities.ProductImage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductImageDaoImpl implements ProductImageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductImage> getList() {
        TypedQuery<ProductImage> query = entityManager.createQuery("SELECT pi FROM ProductImage pi", ProductImage.class);
        return query.getResultList();
    }

    @Override
    public ProductImage getById(Long id) {
        return entityManager.find(ProductImage.class, id);
    }

    @Override
    public ProductImage create(ProductImage productImage) {
        entityManager.persist(productImage);
        return productImage;
    }

    @Override
    public ProductImage update(ProductImage productImage) {
        return entityManager.merge(productImage);
    }

    @Override
    public void delete(Long id) {
        ProductImage productImage = getById(id);
        if (productImage != null) {
            entityManager.remove(productImage);
        }
    }

    @Override
    public List<ProductImage> getProductImagesByProductId(Long productId) {
        TypedQuery<ProductImage> query = entityManager.createQuery("SELECT pi FROM ProductImage pi WHERE pi.product.id = :productId", ProductImage.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    @Override
    public ProductImage findByImageUrl(String imageUrl) {
        TypedQuery<ProductImage> query = entityManager.createQuery("SELECT pi FROM ProductImage pi WHERE pi.imageUrl = :imageUrl", ProductImage.class);
        query.setParameter("imageUrl", imageUrl);
        return query.getSingleResult();
    }
}