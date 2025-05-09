package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.LettreAffectation;
import com.dsi.projetgestionpfe.repositories.LettreAffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LettreAffectationServiceImpl implements LettreAffectationService {

    @Autowired
    private LettreAffectationRepository lettreAffectationRepository;

    @Override
    public List<LettreAffectation> getAllLettresAffectation() {
        return lettreAffectationRepository.findAll();
    }

    @Override
    public LettreAffectation getLettreAffectationById(int id) {
        return lettreAffectationRepository.findById(id).orElse(null);
    }

    @Override
    public LettreAffectation createLettreAffectation(LettreAffectation lettreAffectation) {
        if (lettreAffectation.getNomEntreprise() == null || lettreAffectation.getNomEntreprise().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'entreprise ne peut pas être vide.");
        }

        if (lettreAffectation.getEtudiant() == null) {
            throw new IllegalArgumentException("Une lettre d'affectation doit être associée à un étudiant.");
        }

        if (lettreAffectation.getPfe() == null) {
            throw new IllegalArgumentException("Une lettre d'affectation doit être associée à un PFE.");
        }

        return lettreAffectationRepository.save(lettreAffectation);
    }

    @Override
    public LettreAffectation updateLettreAffectation(LettreAffectation lettreAffectation) {
        Optional<LettreAffectation> lettreOptional = lettreAffectationRepository.findById(lettreAffectation.getIdDoc());
        if (lettreOptional.isPresent()) {
            LettreAffectation lettreToUpdate = lettreOptional.get();

            if (lettreAffectation.getNomEntreprise() == null || lettreAffectation.getNomEntreprise().isEmpty()) {
                throw new IllegalArgumentException("Le nom de l'entreprise ne peut pas être vide.");
            }

            if (lettreAffectation.getEtudiant() == null) {
                throw new IllegalArgumentException("Une lettre d'affectation doit être associée à un étudiant.");
            }

            if (lettreAffectation.getPfe() == null) {
                throw new IllegalArgumentException("Une lettre d'affectation doit être associée à un PFE.");
            }

            // Update all relevant fields
            lettreToUpdate.setNomEntreprise(lettreAffectation.getNomEntreprise());


            return lettreAffectationRepository.save(lettreToUpdate);
        }
        return null;
    }

    @Override
    public void deleteLettreAffectation(int id) {
        if (!lettreAffectationRepository.existsById(id)) {
            throw new IllegalArgumentException("La lettre d'affectation avec l'ID " + id + " n'existe pas.");
        }
        lettreAffectationRepository.deleteById(id);
    }
}