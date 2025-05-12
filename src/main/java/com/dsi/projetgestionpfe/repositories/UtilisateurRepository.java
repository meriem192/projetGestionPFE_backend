package com.dsi.projetgestionpfe.repositories;


import com.dsi.projetgestionpfe.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByEmailAndPassword(String email, String password);
    Optional<Utilisateur> findByPassword(String password);
}
