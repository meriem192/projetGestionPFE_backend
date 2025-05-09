package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Notification;
import com.dsi.projetgestionpfe.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable int id) {
        return notificationService.getNotificationById(id);
    }

    @PostMapping("/addNotification")
    public Notification addNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @PutMapping("/updateNotification/{id}")
    public Notification updateNotification(@PathVariable int id, @RequestBody Notification notification) {
        notification.setId(id);
        return notificationService.updateNotification(notification);
    }

    @DeleteMapping("/deleteNotification/{id}")
    public void deleteNotification(@PathVariable int id) {
        notificationService.deleteNotification(id);
    }

    @GetMapping("/destinataire/{destinataireId}")
    public List<Notification> getNotificationsByDestinataire(@PathVariable int destinataireId) {
        return notificationService.getNotificationsByDestinataire(destinataireId);
    }
}