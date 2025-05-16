package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Rapport;
import java.util.List;

public interface RapportService {
    List<Rapport> getAllRapports();
    Rapport getRapportById(int id);
    Rapport createRapport(Rapport rapport);
    Rapport updateRapport(Rapport rapport);
    void deleteRapport(int id);
}