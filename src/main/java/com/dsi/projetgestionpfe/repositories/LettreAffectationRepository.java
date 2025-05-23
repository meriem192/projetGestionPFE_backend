package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.LettreAffectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LettreAffectationRepository extends JpaRepository<LettreAffectation, Integer> {
}
