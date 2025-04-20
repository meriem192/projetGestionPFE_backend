package com.dsi.projetgestionpfe.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class EnseignantJury {
    private Long enseignantId;
    @Enumerated(EnumType.STRING)
    private Qualificatif qualificateur;
}
