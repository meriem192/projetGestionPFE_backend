package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Pfe;
import com.dsi.projetgestionpfe.entities.Statut;
import com.dsi.projetgestionpfe.repositories.PfeRepository;
import com.dsi.projetgestionpfe.repositories.JuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PfeServiceImpl implements PfeService {

    @Autowired
    private PfeRepository pfeRepository;

    @Autowired
    private JuryRepository juryRepository;

    @Override
    public List<Pfe> getAllPfe() {
        return pfeRepository.findAll();
    }

    @Override
    public Pfe getPfeById(int id) {
        return pfeRepository.findById(id).orElse(null);
    }

    @Override
    public Pfe createPfe(Pfe pfe) {
        if (pfe.getSujet() == null || pfe.getSujet().isEmpty()) {
            throw new IllegalArgumentException("Le sujet du PFE ne peut pas être vide.");
        }

        if (pfe.getStatut() == null) {
            throw new IllegalArgumentException("Le statut du PFE doit être spécifié.");
        }

        // Validate jury if present
        if (pfe.getJury() != null && !juryRepository.existsById(pfe.getJury().getId())) {
            throw new IllegalArgumentException("Le jury spécifié n'existe pas.");
        }

        return pfeRepository.save(pfe);
    }

    @Override
    public Pfe updatePfe(Pfe pfe) {
        Optional<Pfe> pfeOptional = pfeRepository.findById(pfe.getId());
        if (pfeOptional.isPresent()) {
            Pfe pfeToUpdate = pfeOptional.get();

            if (pfe.getSujet() == null || pfe.getSujet().isEmpty()) {
                throw new IllegalArgumentException("Le sujet du PFE ne peut pas être vide.");
            }

            if (pfe.getStatut() == null) {
                throw new IllegalArgumentException("Le statut du PFE doit être spécifié.");
            }

            // Validate jury if present
            if (pfe.getJury() != null && !juryRepository.existsById(pfe.getJury().getId())) {
                throw new IllegalArgumentException("Le jury spécifié n'existe pas.");
            }

            // Update fields
            pfeToUpdate.setSujet(pfe.getSujet());
            pfeToUpdate.setStatut(pfe.getStatut());

            return pfeRepository.save(pfeToUpdate);
        }
        return null;
    }

    @Override
    public void deletePfe(int id) {
        if (!pfeRepository.existsById(id)) {
            throw new IllegalArgumentException("Le PFE avec l'ID " + id + " n'existe pas.");
        }
        pfeRepository.deleteById(id);
    }

    @Override
    public List<Pfe> getPfeByStatut(Statut statut) {
        if (statut == null) {
            throw new IllegalArgumentException("Le statut ne peut pas être null.");
        }
        return pfeRepository.findByStatut(statut);
    }

    @Override
    public List<Pfe> getPfeByJury(int juryId) {
        if (!juryRepository.existsById(juryId)) {
            throw new IllegalArgumentException("Le jury avec l'ID " + juryId + " n'existe pas.");
        }
        return pfeRepository.findByJuryId(juryId);
    }
}