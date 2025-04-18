package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.entities.Feedback;
import com.dsi.projetgestionpfe.entities.Rapport;

import java.util.List;

public interface EnseignantService {
    //crud enseignant
    List<Enseignant> getEnseignants();
    Enseignant getEnseignantById(long id);
    Enseignant updateEnseignant(Enseignant enseignant);
    boolean deleteEnseignant(long id);

    //méthodes supp
    boolean validerEncadrement(Long enseignantId, Long demandeId, boolean isValide, String commentaire);
    Feedback fournirFeedback(Long enseignantId, Feedback feedback);
    boolean evaluerRapport(Long enseignantId, Long rapportId, double note, String commentaire);
    List<Rapport> getRapportsAEvaluer(long enseignantId);
}
