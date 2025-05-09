package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.LettreAffectation;
import java.util.List;

public interface LettreAffectationService {
    List<LettreAffectation> getAllLettresAffectation();
    LettreAffectation getLettreAffectationById(int id);
    LettreAffectation createLettreAffectation(LettreAffectation lettreAffectation);
    LettreAffectation updateLettreAffectation(LettreAffectation lettreAffectation);
    void deleteLettreAffectation(int id);
}