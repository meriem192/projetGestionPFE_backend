package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.DemandeEncadrement;
import com.dsi.projetgestionpfe.entities.Statut;

import java.util.List;

public interface DemandeEncadrementService {
    List<DemandeEncadrement> getAllDemandes();
    DemandeEncadrement getDemandeById(int id);
    DemandeEncadrement createDemande(DemandeEncadrement demande);
    DemandeEncadrement updateDemande(DemandeEncadrement demande);
    void deleteDemande(int id);
    List<DemandeEncadrement> getDemandesByEtudiant(int etudiantId);
    List<DemandeEncadrement> getDemandesByEnseignant(int enseignantId);
    List<DemandeEncadrement> getDemandesByStatut(Statut statut);
}