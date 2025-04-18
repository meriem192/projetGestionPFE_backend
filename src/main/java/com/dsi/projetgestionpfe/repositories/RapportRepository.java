package com.dsi.projetgestionpfe.repositories;


import com.dsi.projetgestionpfe.entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {
}
