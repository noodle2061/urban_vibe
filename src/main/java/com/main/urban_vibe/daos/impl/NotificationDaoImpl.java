package com.main.urban_vibe.daos.impl;

import com.main.urban_vibe.daos.NotificationDao;
import com.main.urban_vibe.entities.Notification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class NotificationDaoImpl implements NotificationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Notification> getList() {
        TypedQuery<Notification> query = entityManager.createQuery("SELECT n FROM Notification n", Notification.class);
        return query.getResultList();
    }

    @Override
    public Notification getById(Long id) {
        return entityManager.find(Notification.class, id);
    }

    @Override
    public Notification create(Notification notification) {
        entityManager.persist(notification);
        return notification;
    }

    @Override
    public Notification update(Notification notification) {
        return entityManager.merge(notification);
    }

    @Override
    public void delete(Long id) {
        Notification notification = getById(id);
        if (notification != null) {
            entityManager.remove(notification);
        }
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long userId) {
        TypedQuery<Notification> query = entityManager.createQuery("SELECT n FROM Notification n WHERE n.user.id = :userId", Notification.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Notification> getUnreadNotificationsByUserId(Long userId) {
        TypedQuery<Notification> query = entityManager.createQuery("SELECT n FROM Notification n WHERE n.user.id = :userId AND n.status = 'UNREAD'", Notification.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public void markNotificationAsRead(Long id) {
        Notification notification = getById(id);
        if (notification != null) {
            notification.setStatus("READ");
            update(notification);
        }
    }
}