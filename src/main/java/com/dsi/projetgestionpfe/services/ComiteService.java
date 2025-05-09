package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Comite;

import java.util.List;

public interface ComiteService {
    //crud comité
    List<Comite> getComites();
    Comite getComiteById(int id);
    Comite createComite(Comite comite);
    Comite updateComite(Comite comite);
    void deleteComite(int id);


}
