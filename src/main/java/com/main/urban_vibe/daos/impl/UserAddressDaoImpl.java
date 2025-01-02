package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.UserAddressDao;
import com.main.urban_vibe.entities.UserAddress;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserAddressDaoImpl implements UserAddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserAddress> getList() {
        TypedQuery<UserAddress> query = entityManager.createQuery("SELECT ua FROM UserAddress ua", UserAddress.class);
        return query.getResultList();
    }

    @Override
    public UserAddress getById(Long id) {
        return entityManager.find(UserAddress.class, id);
    }

    @Override
    public UserAddress create(UserAddress userAddress) {
        entityManager.persist(userAddress);
        return userAddress;
    }

    @Override
    public UserAddress update(UserAddress userAddress) {
        return entityManager.merge(userAddress);
    }

    @Override
    public void delete(Long id) {
        UserAddress userAddress = getById(id);
        if (userAddress != null) {
            entityManager.remove(userAddress);
        }
    }

    @Override
    public List<UserAddress> getUserAddressesByUserId(Long userId) {
        TypedQuery<UserAddress> query = entityManager.createQuery("SELECT ua FROM UserAddress ua WHERE ua.user.id = :userId", UserAddress.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public UserAddress findDefaultAddressByUserId(Long userId) {
        TypedQuery<UserAddress> query = entityManager.createQuery("SELECT ua FROM UserAddress ua WHERE ua.user.id = :userId AND ua.isDefault = true", UserAddress.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }
}