package com.dsi.projetgestionpfe.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class EnseignantJury {
    @Enumerated(EnumType.STRING)
    private Qualificatif qualificateur;
}
