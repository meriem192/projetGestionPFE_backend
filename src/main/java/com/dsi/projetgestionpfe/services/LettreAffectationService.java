package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.LettreAffectation;
import com.dsi.projetgestionpfe.entities.Statut;

import java.util.List;

public interface LettreAffectationService {
    LettreAffectation createLettre(LettreAffectation lettre);
    LettreAffectation getLettreById(Long id);
    List<LettreAffectation> getAllLettres();
    LettreAffectation updateLettre(Long id, LettreAffectation lettre);
    void deleteLettre(Long id);

    LettreAffectation deposerLettre(Long etudiantId, String entreprise, byte[] contenu);
    LettreAffectation validerLettre(Long lettreId, Long enseignantId, boolean isValide, String commentaire);
    List<LettreAffectation> getLettresByEtudiant(Long etudiantId);
    List<LettreAffectation> getLettresByStatut(Statut statut);

    byte[] genererLettreModele(Long etudiantId);
}
