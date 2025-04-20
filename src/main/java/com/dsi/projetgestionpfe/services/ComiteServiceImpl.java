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
        return comiteRepository.save(comite);
    }

    @Override
    public Comite updateComite(Comite comite) {
        Optional<Comite>comiteOptional=comiteRepository.findById(comite.getId());
        if(comiteOptional.isPresent()){
            Comite comiteToUpdate=comiteOptional.get();
            comiteToUpdate.setNom(comite.getNom());
            comiteToUpdate.setEnseignants(comite.getEnseignants());
            return comiteRepository.save(comiteToUpdate);
        }
        return null;
    }

    @Override
    public void deleteComite(long id) {
        if(comiteRepository.existsById(id)){
            comiteRepository.deleteById(id);
        }
    }

    @Override
    public boolean addEnseignantToComite(Long comiteId, Long enseignantId) {
        Enseignant enseignant=enseignantRepository.findById(enseignantId).orElse(null);
        Comite comite=comiteRepository.findById(comiteId).orElse(null);
        if(comite.getEnseignants().contains(enseignant)){
            return false;
        }
        comite.getEnseignants().add(enseignant);
        enseignant.getComites().add(comite);
        comiteRepository.save(comite);
        return true;

    }

    @Override
    public boolean removeEnseignantFromComite(Long comiteId, Long enseignantId) {
        Enseignant enseignant=enseignantRepository.findById(enseignantId).orElse(null);
        Comite comite=comiteRepository.findById(comiteId).orElse(null);
        if(!comite.getEnseignants().contains(enseignant)){
            return false;
        }
        comite.getEnseignants().remove(enseignant);
        enseignant.getComites().remove(comite);
        comiteRepository.save(comite);
        return true;
    }
}
