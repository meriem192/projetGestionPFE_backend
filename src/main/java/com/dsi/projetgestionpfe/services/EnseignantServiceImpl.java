package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;
import com.dsi.projetgestionpfe.repositories.DemandeEncadrementRepository;
import com.dsi.projetgestionpfe.repositories.EnseignantRepository;
import com.dsi.projetgestionpfe.repositories.EtudiantRepository;
import com.dsi.projetgestionpfe.repositories.RapportRepository;
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
    private RapportRepository rapportRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Enseignant> getEnseignants() {
        return enseignantRepository.findAll();

    }

    @Override
    public Enseignant getEnseignantById(long id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        Optional<Enseignant> enseignantOpt = enseignantRepository.findById(enseignant.getId());
        if (enseignantOpt.isPresent()) {
            enseignantOpt.get().setNom(enseignant.getNom());
            enseignantOpt.get().setPrenom(enseignant.getPrenom());
            enseignantOpt.get().setEmail(enseignant.getEmail());
            enseignantOpt.get().setPassword(enseignant.getPassword());
            enseignantOpt.get().setSpecialite(enseignant.getSpecialite());
            enseignantOpt.get().setComites(enseignant.getComites());
            return enseignantRepository.save(enseignantOpt.get());
        }
        return null;
    }

    @Override
    public void deleteEnseignant(long id) {
        if (enseignantRepository.existsById(id)) {
            enseignantRepository.deleteById(id);
        }
    }

    @Override
    public boolean validerEncadrement(Long enseignantId, Long demandeId, boolean isValide, String commentaire) {
        DemandeEncadrement demande = demandeEncadrementRepository.findById(demandeId)
                .orElse(null);

        if (demande == null) {
            return false;
        }

        if (demande.getEnseignant().getId()!=enseignantId) {
            return false;
        }

        if (isValide) {
            demande.setStatutDemande(Statut.Accepte);
        } else {
            demande.setStatutDemande(Statut.Refuse);
            demande.setCommentaire(commentaire);
        }

        demandeEncadrementRepository.save(demande);

        return true;
    }

    @Override
    public boolean evaluerRapport(Long enseignantId, Long rapportId, double note, String commentaire) {
        Optional<Rapport> rapportOpt = rapportRepository.findById(rapportId);

        if (rapportOpt.isEmpty()) {
            return false;
        }

        Rapport rapport = rapportOpt.get();
        rapport.setNote(note);
        rapport.setCommentaire(commentaire);
        rapportRepository.save(rapport);
        return true;
    }




    }
