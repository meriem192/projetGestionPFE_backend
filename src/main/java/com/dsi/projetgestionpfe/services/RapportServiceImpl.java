package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Rapport;
import com.dsi.projetgestionpfe.repositories.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportServiceImpl implements RapportService{
    @Autowired
    private RapportRepository rapportRepository;
    @Override
    public Rapport createRapport(Rapport rapport) {
        return null;
    }

    @Override
    public Rapport getRapportById(Long id) {
        return null;
    }

    @Override
    public List<Rapport> getAllRapports() {
        return List.of();
    }

    @Override
    public Rapport updateRapport(Long id, Rapport updatedRapport) {
        return null;
    }

    @Override
    public void deleteRapport(Long id) {

    }

    @Override
    public Rapport deposerRapport(Long etudiantId, String titre, byte[] contenu) {
        return null;
    }

    @Override
    public List<Rapport> getHistoriqueRapports(Long etudiantId) {
        return List.of();
    }

    @Override
    public void validerRapport(Long rapportId, Long enseignantId) {

    }
}
