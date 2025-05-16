package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;
import com.dsi.projetgestionpfe.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeEncadrementServiceImpl implements DemandeEncadrementService {

    @Autowired
    private DemandeEncadrementRepository demandeRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public List<DemandeEncadrement> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @Override
    public DemandeEncadrement getDemandeById(int id) {
        return demandeRepository.findById(id).orElse(null);
    }

    @Override
    public DemandeEncadrement createDemande(DemandeEncadrement demande) {
        // Basic validation
        if (demande.getEtudiant() == null) {
            throw new IllegalArgumentException("L'étudiant doit être spécifié.");
        }

        if (demande.getEnseignant() == null) {
            throw new IllegalArgumentException("L'enseignant doit être spécifié.");
        }

        if (demande.getSujetPropose() == null || demande.getSujetPropose().isEmpty()) {
            throw new IllegalArgumentException("Le sujet proposé ne peut pas être vide.");
        }

        // Verify existence of related entities
        if (!etudiantRepository.existsById(demande.getEtudiant().getId())) {
            throw new IllegalArgumentException("L'étudiant spécifié n'existe pas.");
        }

        if (!enseignantRepository.existsById(demande.getEnseignant().getId())) {
            throw new IllegalArgumentException("L'enseignant spécifié n'existe pas.");
        }

        if (demande.getStatutDemande() == null) {
            demande.setStatutDemande(Statut.En_attente);
        }

        if (demande.getDateDemande() == null) {
            demande.setDateDemande(LocalDate.now());
        }

        return demandeRepository.save(demande);
    }

    @Override
    public DemandeEncadrement updateDemande(DemandeEncadrement demande) {
        Optional<DemandeEncadrement> existingDemande = demandeRepository.findById(demande.getId());
        if (existingDemande.isPresent()) {
            DemandeEncadrement demandeToUpdate = existingDemande.get();

            // Validate fields
            if (demande.getSujetPropose() == null || demande.getSujetPropose().isEmpty()) {
                throw new IllegalArgumentException("Le sujet proposé ne peut pas être vide.");
            }

            // Update fields
            demandeToUpdate.setSujetPropose(demande.getSujetPropose());
            demandeToUpdate.setCommentaire(demande.getCommentaire());
            demandeToUpdate.setStatutDemande(demande.getStatutDemande());

            return demandeRepository.save(demandeToUpdate);
        }
        return null;
    }

    @Override
    public void deleteDemande(int id) {
        if (!demandeRepository.existsById(id)) {
            throw new IllegalArgumentException("La demande avec l'ID " + id + " n'existe pas.");
        }
        demandeRepository.deleteById(id);
    }

    @Override
    public List<DemandeEncadrement> getDemandesByEtudiant(int etudiantId) {
        if (!etudiantRepository.existsById(etudiantId)) {
            throw new IllegalArgumentException("L'étudiant avec l'ID " + etudiantId + " n'existe pas.");
        }
        return demandeRepository.findByEtudiantId(etudiantId);
    }

    @Override
    public List<DemandeEncadrement> getDemandesByEnseignant(int enseignantId) {
        if (!enseignantRepository.existsById(enseignantId)) {
            throw new IllegalArgumentException("L'enseignant avec l'ID " + enseignantId + " n'existe pas.");
        }
        return demandeRepository.findByEnseignantId(enseignantId);
    }

    @Override
    public List<DemandeEncadrement> getDemandesByStatut(Statut statut) {
        if (statut == null) {
            throw new IllegalArgumentException("Le statut ne peut pas être null.");
        }
        return demandeRepository.findByStatutDemande(statut);
    }
}