package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.UserNameDao;
import com.main.urban_vibe.entities.UserName;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserNameDaoImpl implements UserNameDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserName> getList() {
        TypedQuery<UserName> query = entityManager.createQuery("SELECT un FROM UserName un", UserName.class);
        return query.getResultList();
    }

    @Override
    public UserName getById(Long id) {
        return entityManager.find(UserName.class, id);
    }

    @Override
    public UserName create(UserName userName) {
        entityManager.persist(userName);
        return userName;
    }

    @Override
    public UserName update(UserName userName) {
        return entityManager.merge(userName);
    }

    @Override
    public void delete(Long id) {
        UserName userName = getById(id);
        if (userName != null) {
            entityManager.remove(userName);
        }
    }

    @Override
    public UserName findByUserId(Long userId) {
        TypedQuery<UserName> query = entityManager.createQuery("SELECT un FROM UserName un WHERE un.user.id = :userId", UserName.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    @Override
    public UserName findByFullName(String fullName) {
        TypedQuery<UserName> query = entityManager.createQuery("SELECT un FROM UserName un WHERE un.fullName = :fullName", UserName.class);
        query.setParameter("fullName", fullName);
        return query.getSingleResult();
    }
}