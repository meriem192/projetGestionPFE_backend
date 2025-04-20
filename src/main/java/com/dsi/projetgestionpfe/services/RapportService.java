package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Etudiant;
import com.dsi.projetgestionpfe.entities.Feedback;
import com.dsi.projetgestionpfe.entities.LettreAffectation;
import com.dsi.projetgestionpfe.entities.Rapport;

import java.util.List;

public interface RapportService {
    Rapport createRapport(Rapport rapport);
    Rapport getRapportById(Long id);
    List<Rapport> getAllRapports();
    Rapport updateRapport(Long id, Rapport updatedRapport);
    void deleteRapport(Long id);

    Rapport deposerRapport(Long etudiantId, String titre, byte[] contenu);
    List<Rapport> getHistoriqueRapports(Long etudiantId);
    void validerRapport(Long rapportId, Long enseignantId);
}
