package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class DemandeEncadrement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @Enumerated(EnumType.STRING)
    private Statut statutDemande;

    private String sujetPropose;
    private String commentaire;
    private LocalDate dateDemande;


}