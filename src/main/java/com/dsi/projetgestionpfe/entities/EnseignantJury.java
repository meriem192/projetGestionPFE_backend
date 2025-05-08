package com.dsi.projetgestionpfe.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnseignantJury {
    private Long enseignantId;
    @Enumerated(EnumType.STRING)
    private Qualificatif qualificateur;
}
