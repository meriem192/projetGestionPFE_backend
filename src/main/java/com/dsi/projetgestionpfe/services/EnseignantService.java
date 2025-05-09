package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Enseignant;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getEnseignants();
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant getEnseignantById(int id);
    Enseignant updateEnseignant(Enseignant enseignant);
    void deleteEnseignant(int id);


}
