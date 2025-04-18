package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Embeddable
public class DemandeBinome {
    @Enumerated(EnumType.STRING)
    private Statut statut;

    private LocalDate dateCreation;


}
