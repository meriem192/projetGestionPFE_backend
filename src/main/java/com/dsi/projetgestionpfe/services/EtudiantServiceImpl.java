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
        if (etudiant.getNom() == null || etudiant.getPrenom() == null) {
            throw new IllegalArgumentException("Le nom et le prénom sont obligatoires.");
        }

        if (etudiant.getEmail() == null || etudiantRepository.findByEmail(etudiant.getEmail()) != null) {
            throw new IllegalArgumentException("L'email est soit manquant, soit déjà utilisé.");
        }

        if (etudiant.getNiveau() == null || etudiant.getParcours() == null) {
            throw new IllegalArgumentException("Le niveau et le parcours sont requis.");
        }

        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiantById(int id) {
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
            Etudiant etudiantUpdated = etudiantOptional.get();

            if (etudiant.getEmail() != null && !etudiant.getEmail().equals(etudiantUpdated.getEmail())) {
                if (etudiantRepository.findByEmail(etudiant.getEmail()) != null) {
                    throw new IllegalArgumentException("Un autre étudiant utilise déjà cet email.");
                }
                etudiantUpdated.setEmail(etudiant.getEmail());
            }

            etudiantUpdated.setNom(etudiant.getNom());
            etudiantUpdated.setPrenom(etudiant.getPrenom());
            etudiantUpdated.setPassword(etudiant.getPassword());
            etudiantUpdated.setNiveau(etudiant.getNiveau());
            etudiantUpdated.setParcours(etudiant.getParcours());

            return etudiantRepository.save(etudiantUpdated);
        }

        throw new IllegalArgumentException("Étudiant introuvable.");
    }

    @Override
    public void deleteEtudiant(int id) {

        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
        if (etudiantOptional.isPresent()) {
            Etudiant etudiant = etudiantOptional.get();

            if (!etudiant.getRapports().isEmpty()) {
                throw new IllegalArgumentException("Cet étudiant a des rapports associés et ne peut pas être supprimé.");
            }

            if (!etudiant.getLettres().isEmpty()) {
                throw new IllegalArgumentException("Cet étudiant a des lettres d'affectation associées et ne peut pas être supprimé.");
            }

            if (!etudiant.getDemandesBinomeEnvoyees().isEmpty() || !etudiant.getDemandesBinomeRecues().isEmpty()) {
                throw new IllegalArgumentException("Cet étudiant a des demandes de binôme associées et ne peut pas être supprimé.");
            }

            etudiantRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("L'étudiant avec l'ID spécifié n'existe pas.");
        }
    }

    @Override
    public List<Etudiant> findByParcours(Parcours parcours) {
        if (parcours == null) {
            throw new IllegalArgumentException("Le parcours ne peut pas être nul.");
        }
        return etudiantRepository.findByParcours(parcours);
    }


}
