package com.dsi.projetgestionpfe.repositories;


import com.dsi.projetgestionpfe.entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {
    List<Rapport> findRapportsNonEvaluesByEnseignantId(@Param("enseignantId") Long enseignantId);

}
