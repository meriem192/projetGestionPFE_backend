package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Comite;

import java.util.List;

public interface ComiteService {
    //crud comité
    List<Comite> getComites();
    Comite getComiteById(long id);
    Comite createComite(Comite comite);
    Comite updateComite(Comite comite);
    boolean deleteComite(long id);

    //gestion enseignants
    boolean addEnseignantToComite(Long comiteId, Long enseignantId);
    boolean removeEnseignantFromComite(Long comiteId, Long enseignantId);

}
