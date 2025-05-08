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
    public Jury getJuryById(int id) {
        return juryRepository.findById(id).orElse(null);
    }

    @Override
    public Jury createJury(Jury jury) {
        if (jury.getEnseignantsJury().isEmpty()) {
            throw new RuntimeException("Le jury doit contenir au moins un enseignant.");
        }

        return juryRepository.save(jury);    }

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
    public void deleteJury(int id) {
        if (juryRepository.existsById(id)) {
            juryRepository.deleteById(id);
        }
    }



}
