package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LettreAffectation {
    @Id
    private long id;
    private byte[] contenue;
    private String nomEntreprise;
    private LocalDate dateSoumission;
    private Statut statut;
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
}
