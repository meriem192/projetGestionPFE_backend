package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Notification;
import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Notification getNotificationById(int id);
    Notification createNotification(Notification notification);
    Notification updateNotification(Notification notification);
    void deleteNotification(int id);
    List<Notification> getNotificationsByDestinataire(int destinataireId);
}