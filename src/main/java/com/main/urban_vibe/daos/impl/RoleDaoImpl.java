package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.RoleDao;
import com.main.urban_vibe.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getList() {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r", Role.class);
        return query.getResultList();
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role create(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        return entityManager.merge(role);
    }

    @Override
    public void delete(Long id) {
        Role role = getById(id);
        if (role != null) {
            entityManager.remove(role);
        }
    }

    @Override
    public Role findByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}