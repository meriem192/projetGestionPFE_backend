package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Comite;
import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.repositories.ComiteRepository;
import com.dsi.projetgestionpfe.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComiteServiceImpl implements ComiteService{
    @Autowired
    private ComiteRepository comiteRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public List<Comite> getComites() {
        return comiteRepository.findAll();
    }

    @Override
    public Comite getComiteById(long id) {
        return comiteRepository.findById(id).orElse(null);
    }

    @Override
    public Comite createComite(Comite comite) {

        if (comite.getNom() == null) {
            throw new IllegalArgumentException("Le nom du comité ne peut pas être vide.");
        }

        if (comite.getEnseignants() == null) {
            throw new IllegalArgumentException("Un comité doit avoir au moins un enseignant.");
        }

        return comiteRepository.save(comite);    }

    @Override
    public Comite updateComite(Comite comite) {
        Optional<Comite> comiteOptional = comiteRepository.findById(comite.getId());
        if (comiteOptional.isPresent()) {
            Comite comiteToUpdate = comiteOptional.get();
            if (comite.getNom() == null) {
                throw new IllegalArgumentException("Le nom du comité ne peut pas être vide.");
            }
            if (comite.getEnseignants() == null) {
                throw new IllegalArgumentException("Le comité doit avoir au moins un enseignant.");
            }

            comiteToUpdate.setNom(comite.getNom());
            comiteToUpdate.setEnseignants(comite.getEnseignants());
            return comiteRepository.save(comiteToUpdate);
        }
        return null;
    }

    @Override
    public void deleteComite(long id) {
        if (!comiteRepository.existsById(id)) {
            throw new IllegalArgumentException("Le comité avec l'ID " + id + " n'existe pas.");
        }
        comiteRepository.deleteById(id);
    }




}
