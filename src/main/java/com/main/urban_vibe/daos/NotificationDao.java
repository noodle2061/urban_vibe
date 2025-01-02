package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Notification;
import java.util.List;

public interface NotificationDao {
    List<Notification> getList();
    Notification getById(Long id);
    Notification create(Notification notification);
    Notification update(Notification notification);
    void delete(Long id);

    List<Notification> getNotificationsByUserId(Long userId);
    List<Notification> getUnreadNotificationsByUserId(Long userId);
    void markNotificationAsRead(Long id);
}