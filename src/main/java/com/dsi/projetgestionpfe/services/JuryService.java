package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.entities.Jury;
import com.dsi.projetgestionpfe.entities.Qualificatif;

import java.util.List;

public interface JuryService {
    //Crud
     List<Jury> getAllJury();
     Jury getJuryById(int id);
     Jury createJury(Jury jury);
     Jury updateJury(Jury jury);
     void deleteJury(int id);

}
