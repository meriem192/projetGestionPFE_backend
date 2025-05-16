package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.CahierDesCharges;
import java.util.List;

public interface CahierDesChargesService {
    List<CahierDesCharges> getAllCahiersDesCharges();
    CahierDesCharges getCahierDesChargesById(int id);
    CahierDesCharges createCahierDesCharges(CahierDesCharges cahierDesCharges);
    CahierDesCharges updateCahierDesCharges(CahierDesCharges cahierDesCharges);
    void deleteCahierDesCharges(int id);
}