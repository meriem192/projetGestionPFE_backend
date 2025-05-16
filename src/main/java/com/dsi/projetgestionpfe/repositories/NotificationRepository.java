package com.dsi.projetgestionpfe.repositories;


import com.dsi.projetgestionpfe.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByDestinataireId(int destinataireId);

}
