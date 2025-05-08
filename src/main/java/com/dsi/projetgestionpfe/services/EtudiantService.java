package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface EtudiantService {
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(Long id);
    List<Etudiant> getAllEtudiants();
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
    List<Etudiant> findByParcours(Parcours parcours);
    DemandeBinome envoyerDemandeBinome(Long etudiantEmetteurId, Long etudiantRecepteurId);
    boolean repondreDemandeBinome(LocalDate date, boolean acceptee);
    List<DemandeBinome> consulterDemandesRecues(Long etudiantId);


}