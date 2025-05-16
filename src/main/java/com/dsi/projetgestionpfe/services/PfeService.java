package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Pfe;
import com.dsi.projetgestionpfe.entities.Statut;

import java.util.List;

public interface PfeService {
    List<Pfe> getAllPfe();
    Pfe getPfeById(int id);
    Pfe createPfe(Pfe pfe);
    Pfe updatePfe(Pfe pfe);
    void deletePfe(int id);
    List<Pfe> getPfeByStatut(Statut statut);
    List<Pfe> getPfeByJury(int juryId);
}