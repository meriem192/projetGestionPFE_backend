package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.CahierDesCharges;
import com.dsi.projetgestionpfe.repositories.CahierDesChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CahierDesChargesServiceImpl implements CahierDesChargesService {

    @Autowired
    private CahierDesChargesRepository cahierDesChargesRepository;

    @Override
    public List<CahierDesCharges> getAllCahiersDesCharges() {
        return cahierDesChargesRepository.findAll();
    }

    @Override
    public CahierDesCharges getCahierDesChargesById(int id) {
        return cahierDesChargesRepository.findById(id).orElse(null);
    }

    @Override
    public CahierDesCharges createCahierDesCharges(CahierDesCharges cahierDesCharges) {
        return cahierDesChargesRepository.save(cahierDesCharges);
    }

    @Override
    public CahierDesCharges updateCahierDesCharges(CahierDesCharges cahierDesCharges) {
        Optional<CahierDesCharges> cahierOptional = cahierDesChargesRepository.findById(cahierDesCharges.getIdDoc());
        if (cahierOptional.isPresent()) {
            CahierDesCharges cahierToUpdate = cahierOptional.get();


            return cahierDesChargesRepository.save(cahierToUpdate);
        }
        return null;
    }

    @Override
    public void deleteCahierDesCharges(int id) {
        if (!cahierDesChargesRepository.existsById(id)) {
            throw new IllegalArgumentException("Le cahier des charges avec l'ID " + id + " n'existe pas.");
        }
        cahierDesChargesRepository.deleteById(id);
    }
}