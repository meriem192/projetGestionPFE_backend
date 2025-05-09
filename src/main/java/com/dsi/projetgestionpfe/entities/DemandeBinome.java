package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DemandeBinome {
    @Enumerated(EnumType.STRING)
    private Statut statut;

    private LocalDate dateCreation;

    @Column(name = "etudiant_source_id", insertable = false, updatable = false)
    private int etudiantSourceId;

    @Column(name = "etudiant_cible_id", insertable = false, updatable = false)
    private int etudiantCibleId;
}
