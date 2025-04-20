package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.entities.Jury;
import com.dsi.projetgestionpfe.entities.Qualificatif;

import java.util.List;

public interface JuryService {
    //Crud
     List<Jury> getAllJury();
     Jury getJuryById(long id);
     Jury createJury(Jury jury);
     Jury updateJury(Jury jury);
     void deleteJury(long id);

    // Gestion des membres du jury
    boolean addEnseignantToJury(long juryId, long enseignantId, Qualificatif qualificatif);
    boolean removeEnseignantFromJury(long juryId, long enseignantId);
    List<Enseignant> getEnseignantsByJury(long juryId);
    List<Enseignant> getEnseignantsByQualificatif(Qualificatif qualificatif);

    // Gestion des qualifications
    boolean updateQualificatif(long juryId, long enseignantId, Qualificatif newQualificatif);

    // Méthodes spécifiques
    List<Jury> getJurysByEnseignant(long enseignantId);
    boolean validateJuryComposition(long juryId);

}
