package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface EtudiantService {
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(int id);
    List<Etudiant> getAllEtudiants();
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(int id);
    List<Etudiant> findByParcours(Parcours parcours);



}