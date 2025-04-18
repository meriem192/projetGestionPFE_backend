package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
