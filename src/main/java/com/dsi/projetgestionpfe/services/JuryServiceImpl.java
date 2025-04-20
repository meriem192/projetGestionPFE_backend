package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.entities.EnseignantJury;
import com.dsi.projetgestionpfe.entities.Jury;
import com.dsi.projetgestionpfe.entities.Qualificatif;
import com.dsi.projetgestionpfe.repositories.EnseignantRepository;
import com.dsi.projetgestionpfe.repositories.JuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuryServiceImpl implements JuryService {
    @Autowired
    private JuryRepository juryRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public List<Jury> getAllJury() {
        return juryRepository.findAll();
    }

    @Override
    public Jury getJuryById(long id) {
        return juryRepository.findById(id).orElse(null);
    }

    @Override
    public Jury createJury(Jury jury) {
        return juryRepository.save(jury);
    }

    @Override
    public Jury updateJury(Jury jury) {
        Optional<Jury> optionalJury = juryRepository.findById(jury.getId());
        if (optionalJury.isPresent()) {
            Jury j = optionalJury.get();
            j.setEnseignantsJury(jury.getEnseignantsJury());
            return juryRepository.save(j);

        }
        return null;
    }

    @Override
    public void deleteJury(long id) {
        if (juryRepository.existsById(id)) {
            juryRepository.deleteById(id);
        }
    }

    @Override
    public boolean addEnseignantToJury(long juryId, long enseignantId, Qualificatif qualificatif) {
        Jury jury = juryRepository.findById(juryId).orElse(null);
        if (jury == null || !enseignantRepository.existsById(enseignantId)) {
            return false;
        }

        Enseignant enseignant = enseignantRepository.findById(enseignantId).orElse(null);
        if (enseignant == null) {
            return false;
        }
        EnseignantJury enseignantJury = new EnseignantJury();
        enseignantJury.setQualificateur(qualificatif);
        jury.getEnseignantsJury().add(enseignantJury);

        juryRepository.save(jury);
        return true;
    }


    @Override
    public boolean removeEnseignantFromJury(long juryId, long enseignantId) {
        return false;
    }

    @Override
    public List<Enseignant> getEnseignantsByJury(long juryId) {
        return List.of();
    }

    @Override
    public List<Enseignant> getEnseignantsByQualificatif(Qualificatif qualificatif) {
        return List.of();
    }

    @Override
    public boolean updateQualificatif(long juryId, long enseignantId, Qualificatif newQualificatif) {
        return false;
    }

    @Override
    public List<Jury> getJurysByEnseignant(long enseignantId) {
        return List.of();
    }

    @Override
    public boolean validateJuryComposition(long juryId) {
        return false;
    }
}
