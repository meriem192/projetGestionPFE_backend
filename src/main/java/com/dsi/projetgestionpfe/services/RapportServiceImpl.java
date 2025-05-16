package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Rapport;
import com.dsi.projetgestionpfe.repositories.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RapportServiceImpl implements RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    @Override
    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }

    @Override
    public Rapport getRapportById(int id) {
        return rapportRepository.findById(id).orElse(null);
    }

    @Override
    public Rapport createRapport(Rapport rapport) {
        if (rapport.getTitre() == null || rapport.getTitre().isEmpty()) {
            throw new IllegalArgumentException("Le titre du rapport ne peut pas être vide.");
        }

        if (rapport.getNote() < 0 || rapport.getNote() > 20) {
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 20.");
        }

        return rapportRepository.save(rapport);
    }

    @Override
    public Rapport updateRapport(Rapport rapport) {
        Optional<Rapport> rapportOptional = rapportRepository.findById(rapport.getId());
        if (rapportOptional.isPresent()) {
            Rapport rapportToUpdate = rapportOptional.get();

            if (rapport.getTitre() == null || rapport.getTitre().isEmpty()) {
                throw new IllegalArgumentException("Le titre du rapport ne peut pas être vide.");
            }


            if (rapport.getNote() < 0 || rapport.getNote() > 20) {
                throw new IllegalArgumentException("La note doit être comprise entre 0 et 20.");
            }

            rapportToUpdate.setTitre(rapport.getTitre());
            rapportToUpdate.setNote(rapport.getNote());
            rapportToUpdate.setCommentaire(rapport.getCommentaire());


            return rapportRepository.save(rapportToUpdate);
        }
        return null;
    }

    @Override
    public void deleteRapport(int id) {
        if (!rapportRepository.existsById(id)) {
            throw new IllegalArgumentException("Le rapport avec l'ID " + id + " n'existe pas.");
        }
        rapportRepository.deleteById(id);
    }
}