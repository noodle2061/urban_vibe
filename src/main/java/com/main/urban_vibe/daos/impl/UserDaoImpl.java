package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.UserDao;
import com.main.urban_vibe.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getList() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public List<User> findByRole(String roleName) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u JOIN u.role r WHERE r.name = :roleName", User.class);
        query.setParameter("roleName", roleName);
        return query.getResultList();
    }
}