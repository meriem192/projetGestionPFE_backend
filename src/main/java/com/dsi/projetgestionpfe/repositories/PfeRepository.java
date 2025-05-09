package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.Pfe;
import com.dsi.projetgestionpfe.entities.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PfeRepository extends JpaRepository<Pfe, Integer> {
    List<Pfe> findByStatut(Statut statut);
    List<Pfe> findByJuryId(int juryId);
}
