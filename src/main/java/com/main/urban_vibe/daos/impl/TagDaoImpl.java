package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.TagDao;
import com.main.urban_vibe.entities.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TagDaoImpl implements TagDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tag> getList() {
        TypedQuery<Tag> query = entityManager.createQuery("SELECT t FROM Tag t", Tag.class);
        return query.getResultList();
    }

    @Override
    public Tag getById(Long id) {
        return entityManager.find(Tag.class, id);
    }

    @Override
    public Tag create(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    @Override
    public Tag update(Tag tag) {
        return entityManager.merge(tag);
    }

    @Override
    public void delete(Long id) {
        Tag tag = getById(id);
        if (tag != null) {
            entityManager.remove(tag);
        }
    }

    @Override
    public Tag findByName(String name) {
        TypedQuery<Tag> query = entityManager.createQuery("SELECT t FROM Tag t WHERE t.name = :name", Tag.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}