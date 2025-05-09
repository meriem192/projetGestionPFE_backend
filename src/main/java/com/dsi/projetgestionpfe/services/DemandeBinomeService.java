package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.DemandeBinome;
import com.dsi.projetgestionpfe.entities.Statut;
import java.util.List;

public interface DemandeBinomeService {
    boolean envoyerDemandeBinome(int sourceId, int cibleId);
    void repondreDemandeBinome(int sourceId, int cibleId, Statut reponse);
    List<DemandeBinome> getDemandesEnvoyees(int etudiantId);
    List<DemandeBinome> getDemandesRecues(int etudiantId);
    List<DemandeBinome> getDemandesByStatut(int etudiantId, Statut statut);
}