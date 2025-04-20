package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;

import java.util.List;

public interface EtudiantService {
    //crud etudiant
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(Long id);
    List<Etudiant> getAllEtudiants();
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);

    //gestion binomes
    DemandeBinome envoyerDemandeBinome(Long etudiantEmetteurId, Long etudiantRecepteurId);
    boolean repondreDemandeBinome(Long demandeId, boolean acceptee);
    List<DemandeBinome> consulterDemandesRecues(Long etudiantId);


}