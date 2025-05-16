package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.*;
import com.dsi.projetgestionpfe.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DemandeBinomeServiceImpl implements DemandeBinomeService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public boolean envoyerDemandeBinome(int sourceId, int cibleId) {
        if (sourceId == cibleId) {
            throw new IllegalArgumentException("Un étudiant ne peut pas s'envoyer une demande à lui-même.");
        }

        Etudiant source = etudiantRepository.findById(sourceId)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant source non trouvé"));

        Etudiant cible = etudiantRepository.findById(cibleId)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant cible non trouvé"));

        boolean demandeExistante = source.getDemandesBinomeEnvoyees().stream()
                .anyMatch(d -> d.getEtudiantCibleId() == cibleId);

        if (demandeExistante) {
            throw new IllegalStateException("Une demande existe déjà entre ces étudiants.");
        }

        DemandeBinome demande = new DemandeBinome();
        demande.setStatut(Statut.En_attente);
        demande.setDateCreation(LocalDate.now());
        demande.setEtudiantSourceId(sourceId);
        demande.setEtudiantCibleId(cibleId);

        source.getDemandesBinomeEnvoyees().add(demande);
        cible.getDemandesBinomeRecues().add(demande);

        etudiantRepository.save(source);
        etudiantRepository.save(cible);
        return true;
    }

    @Override
    public void repondreDemandeBinome(int sourceId, int cibleId, Statut reponse) {
        Etudiant cible = etudiantRepository.findById(cibleId)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé"));

        // Find the request in received requests
        DemandeBinome demande = cible.getDemandesBinomeRecues().stream()
                .filter(d -> d.getEtudiantSourceId() == sourceId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Demande non trouvée"));

        demande.setStatut(reponse);
        etudiantRepository.save(cible);
    }

    @Override
    public List<DemandeBinome> getDemandesEnvoyees(int etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé"));
        return etudiant.getDemandesBinomeEnvoyees();
    }

    @Override
    public List<DemandeBinome> getDemandesRecues(int etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé"));
        return etudiant.getDemandesBinomeRecues();
    }

    @Override
    public List<DemandeBinome> getDemandesByStatut(int etudiantId, Statut statut) {
        if (statut == null) {
            throw new IllegalArgumentException("Le statut ne peut pas être null.");
        }

        return getDemandesRecues(etudiantId).stream()
                .filter(d -> d.getStatut() == statut)
                .collect(Collectors.toList());
    }
}

