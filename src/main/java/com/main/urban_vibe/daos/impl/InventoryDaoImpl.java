package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.InventoryDao;
import com.main.urban_vibe.entities.Inventory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class InventoryDaoImpl implements InventoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Inventory> getList() {
        TypedQuery<Inventory> query = entityManager.createQuery("SELECT i FROM Inventory i", Inventory.class);
        return query.getResultList();
    }

    @Override
    public Inventory getById(Long id) {
        return entityManager.find(Inventory.class, id);
    }

    @Override
    public Inventory create(Inventory inventory) {
        entityManager.persist(inventory);
        return inventory;
    }

    @Override
    public Inventory update(Inventory inventory) {
        return entityManager.merge(inventory);
    }

    @Override
    public void delete(Long id) {
        Inventory inventory = getById(id);
        if (inventory != null) {
            entityManager.remove(inventory);
        }
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        TypedQuery<Inventory> query = entityManager.createQuery("SELECT i FROM Inventory i WHERE i.product.id = :productId", Inventory.class);
        query.setParameter("productId", productId);
        return query.getSingleResult();
    }

    @Override
    public List<Inventory> getInventoriesByUserId(Long userId) {
        TypedQuery<Inventory> query = entityManager.createQuery("SELECT i FROM Inventory i WHERE i.user.id = :userId", Inventory.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Inventory> getInventoriesByType(String type) {
        TypedQuery<Inventory> query = entityManager.createQuery("SELECT i FROM Inventory i WHERE i.type = :type", Inventory.class);
        query.setParameter("type", type);
        return query.getResultList();
    }
}