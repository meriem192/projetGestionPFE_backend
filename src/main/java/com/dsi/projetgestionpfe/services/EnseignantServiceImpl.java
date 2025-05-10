package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;
import com.dsi.projetgestionpfe.repositories.DemandeEncadrementRepository;
import com.dsi.projetgestionpfe.repositories.EnseignantRepository;

import com.dsi.projetgestionpfe.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantServiceImpl implements EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private DemandeEncadrementRepository demandeEncadrementRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public List<Enseignant> getEnseignants() {
        return enseignantRepository.findAll();

    }
    public Enseignant addEnseignant(Enseignant enseignant) {
        if (utilisateurRepository.findByEmail(enseignant.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cet email existe déja");
        }
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant getEnseignantById(int id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        if (enseignant.getNom() == null) {
            throw new IllegalArgumentException("Le nom de l'enseignant ne peut pas être vide.");
        }
        if (enseignant.getEmail() == null) {
            throw new IllegalArgumentException("L'email de l'enseignant ne peut pas être vide.");
        }

        Optional<Enseignant> enseignantOpt = enseignantRepository.findById(enseignant.getId());
        if (enseignantOpt.isPresent()) {
            Enseignant enseignantToUpdate = enseignantOpt.get();
            enseignantToUpdate.setNom(enseignant.getNom());
            enseignantToUpdate.setPrenom(enseignant.getPrenom());
            enseignantToUpdate.setEmail(enseignant.getEmail());
            enseignantToUpdate.setPassword(enseignant.getPassword());
            enseignantToUpdate.setSpecialite(enseignant.getSpecialite());

            return enseignantRepository.save(enseignantToUpdate);
        } else {
            throw new IllegalArgumentException("L'enseignant avec l'ID " + enseignant.getId() + " n'existe pas.");
        }
    }

    @Override
    public void deleteEnseignant(int id) {
        Optional<Enseignant> enseignantOpt = enseignantRepository.findById(id);
        if (enseignantOpt.isPresent()) {
            if (!demandeEncadrementRepository.findByEnseignantId(id).isEmpty()) {
                throw new IllegalStateException("L'enseignant a des demandes d'encadrement et ne peut pas être supprimé.");
            }


            enseignantRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("L'enseignant avec l'ID " + id + " n'existe pas.");
        }
    }


    }
