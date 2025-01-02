package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.CommentDao;
import com.main.urban_vibe.entities.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> getList() {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment getById(Long id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public Comment create(Comment comment) {
        entityManager.persist(comment);
        return comment;
    }

    @Override
    public Comment update(Comment comment) {
        return entityManager.merge(comment);
    }

    @Override
    public void delete(Long id) {
        Comment comment = getById(id);
        if (comment != null) {
            entityManager.remove(comment);
        }
    }

    @Override
    public List<Comment> getCommentsByProductId(Long productId) {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment c WHERE c.product.id = :productId", Comment.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment c WHERE c.user.id = :userId", Comment.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}