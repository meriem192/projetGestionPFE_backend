package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.DemandeEncadrement;
import com.dsi.projetgestionpfe.entities.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeEncadrementRepository extends JpaRepository<DemandeEncadrement, Integer> {
    List<DemandeEncadrement> findByEtudiantId(int etudiantId);
    List<DemandeEncadrement> findByEnseignantId(int enseignantId);
    List<DemandeEncadrement> findByStatutDemande(Statut statut);
}
