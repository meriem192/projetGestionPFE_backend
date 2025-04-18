package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private byte[] contenu;
    private LocalDate dateSoumission;
    private double note;
    private String commentaire;
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
}
