package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Notification;
import com.dsi.projetgestionpfe.repositories.NotificationRepository;
import com.dsi.projetgestionpfe.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(int id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public Notification createNotification(Notification notification) {
        if (notification.getMessage() == null || notification.getMessage().isEmpty()) {
            throw new IllegalArgumentException("Le message de la notification ne peut pas être vide.");
        }

        if (notification.getDestinataire() == null) {
            throw new IllegalArgumentException("La notification doit avoir un destinataire.");
        }

        if (notification.getEmetteur() == null) {
            throw new IllegalArgumentException("La notification doit avoir un émetteur.");
        }

        // Verify that users exist in database
        if (!utilisateurRepository.existsById(notification.getDestinataire().getId())) {
            throw new IllegalArgumentException("Le destinataire spécifié n'existe pas.");
        }

        if (!utilisateurRepository.existsById(notification.getEmetteur().getId())) {
            throw new IllegalArgumentException("L'émetteur spécifié n'existe pas.");
        }

        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        Optional<Notification> notificationOptional = notificationRepository.findById(notification.getId());
        if (notificationOptional.isPresent()) {
            Notification notificationToUpdate = notificationOptional.get();

            if (notification.getMessage() == null || notification.getMessage().isEmpty()) {
                throw new IllegalArgumentException("Le message de la notification ne peut pas être vide.");
            }

            if (notification.getDestinataire() == null) {
                throw new IllegalArgumentException("La notification doit avoir un destinataire.");
            }

            if (notification.getEmetteur() == null) {
                throw new IllegalArgumentException("La notification doit avoir un émetteur.");
            }

            // Verify that users exist in database
            if (!utilisateurRepository.existsById(notification.getDestinataire().getId())) {
                throw new IllegalArgumentException("Le destinataire spécifié n'existe pas.");
            }

            if (!utilisateurRepository.existsById(notification.getEmetteur().getId())) {
                throw new IllegalArgumentException("L'émetteur spécifié n'existe pas.");
            }

            // Update fields
            notificationToUpdate.setMessage(notification.getMessage());
            notificationToUpdate.setDestinataire(notification.getDestinataire());
            notificationToUpdate.setEmetteur(notification.getEmetteur());

            return notificationRepository.save(notificationToUpdate);
        }
        return null;
    }

    @Override
    public void deleteNotification(int id) {
        if (!notificationRepository.existsById(id)) {
            throw new IllegalArgumentException("La notification avec l'ID " + id + " n'existe pas.");
        }
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> getNotificationsByDestinataire(int destinataireId) {
        if (!utilisateurRepository.existsById(destinataireId)) {
            throw new IllegalArgumentException("L'utilisateur avec l'ID " + destinataireId + " n'existe pas.");
        }
        return notificationRepository.findByDestinataireId(destinataireId);
    }
}