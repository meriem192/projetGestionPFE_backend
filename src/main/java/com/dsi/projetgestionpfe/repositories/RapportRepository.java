package com.dsi.projetgestionpfe.repositories;


import com.dsi.projetgestionpfe.entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RapportRepository extends JpaRepository<Rapport, Integer> {
    List<Rapport> findByEnseignantId(long enseignantId);

}
