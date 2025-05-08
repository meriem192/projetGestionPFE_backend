package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.DemandeEncadrement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeEncadrementRepository extends JpaRepository<DemandeEncadrement, Integer> {
    List<DemandeEncadrement> findByEnseignantId(int enseignantId);

}
