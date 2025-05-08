package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.entities.Etudiant;
import com.dsi.projetgestionpfe.entities.Rapport;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getEnseignants();
    Enseignant getEnseignantById(long id);
    Enseignant updateEnseignant(Enseignant enseignant);
    void deleteEnseignant(long id);

    boolean validerEncadrement(Long enseignantId, Long demandeId, boolean isValide, String commentaire);
    boolean evaluerRapport(Long enseignantId, Long rapportId, double note, String commentaire);

}
