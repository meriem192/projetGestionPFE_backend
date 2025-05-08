package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.entities.Etudiant;
import com.dsi.projetgestionpfe.entities.Rapport;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getEnseignants();
    Enseignant getEnseignantById(int id);
    Enseignant updateEnseignant(Enseignant enseignant);
    void deleteEnseignant(int id);


}
