package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;

import java.util.List;

public interface EtudiantService {
    //crud etudiant
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(Long id);
    List<Etudiant> getAllEtudiants();
    Etudiant updateEtudiant(Etudiant etudiant);
    boolean deleteEtudiant(Long id);

    //methodes supp
    Rapport deposerRapport(Long etudiantId, String titre, byte[] contenu);
    LettreAffectation deposerLettreAffectation(Long etudiantId, String entreprise, byte[] contenu);


    //gestion binomes
    DemandeBinome envoyerDemandeBinome(Long etudiantEmetteurId, Long etudiantRecepteurId);
    boolean repondreDemandeBinome(Long demandeId, boolean acceptee);
    List<DemandeBinome> consulterDemandesRecues(Long etudiantId);


}