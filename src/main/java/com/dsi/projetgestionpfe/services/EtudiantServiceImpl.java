package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;
import com.dsi.projetgestionpfe.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(etudiant.getId());
        if (etudiantOptional.isPresent()) {
            etudiantOptional.get().setNom(etudiant.getNom());
            etudiantOptional.get().setPrenom(etudiant.getPrenom());
            etudiantOptional.get().setEmail(etudiant.getEmail());
            etudiantOptional.get().setPassword(etudiant.getPassword());
            etudiantOptional.get().setNiveau(etudiant.getNiveau());
            etudiantOptional.get().setParcours(etudiant.getParcours());
            return etudiantRepository.save(etudiantOptional.get());
        }
        return null;
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> findByParcours(Parcours parcours) {
        return etudiantRepository.findByParcours(parcours);
    }

    @Override
    public DemandeBinome envoyerDemandeBinome(Long etudiantEmetteurId, Long etudiantRecepteurId) {
        Etudiant etudiantEmetteur = etudiantRepository.findById(etudiantEmetteurId)
                .orElseThrow(() -> new RuntimeException("Etudiant émetteur non trouvé"));

        Etudiant etudiantRecepteur = etudiantRepository.findById(etudiantRecepteurId)
                .orElseThrow(() -> new RuntimeException("Etudiant récepteur non trouvé"));

        DemandeBinome demande = new DemandeBinome();
        demande.setStatut(Statut.Soumis);
        demande.setDateCreation(LocalDate.now());

        etudiantEmetteur.getDemandesBinomeEnvoyees().add(demande);
        etudiantRecepteur.getDemandesBinomeRecues().add(demande);

        etudiantRepository.save(etudiantEmetteur);
        etudiantRepository.save(etudiantRecepteur);

        return demande;
    }

    @Override
    public boolean repondreDemandeBinome(LocalDate date, boolean acceptee) {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        for (Etudiant etudiant : etudiants) {
            for (DemandeBinome demandeBinome : etudiant.getDemandesBinomeRecues()) {
                if (demandeBinome.getDateCreation().equals(date)) {
                    demandeBinome.setStatut(acceptee ? Statut.Accepte : Statut.Refuse);
                    etudiantRepository.save(etudiant);
                    return true;
                }
            }
            for (DemandeBinome demandeBinome : etudiant.getDemandesBinomeEnvoyees()) {
                if (demandeBinome.getDateCreation().equals(date)) {
                    demandeBinome.setStatut(acceptee ? Statut.Accepte : Statut.Refuse);
                    etudiantRepository.save(etudiant);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<DemandeBinome> consulterDemandesRecues(Long etudiantId) {
        return List.of();
    }
}
