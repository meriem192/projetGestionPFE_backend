package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.Comite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComiteRepository extends JpaRepository<Comite,Integer> {
    Optional<Comite> findByNom(String nom);
}
