package com.dsi.projetgestionpfe.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant extends Utilisateur{
    private String niveau;
    @Enumerated(EnumType.STRING)
    private Parcours parcours;
    @OneToMany(mappedBy = "etudiant")
    private List<Rapport> rapports;

    @OneToMany(mappedBy = "etudiant")
    private List<LettreAffectation> lettres;
    @ElementCollection
    @CollectionTable(
            name = "demandes_binome_source",
            joinColumns = @JoinColumn(name = "etudiantSource")
    )
    private List<DemandeBinome> demandesBinomeEnvoyees = new ArrayList<>();


    @ElementCollection
    @CollectionTable(
            name = "demandes_binome",
            joinColumns = @JoinColumn(name = "etudiantCible")
    )
    private List<DemandeBinome> demandesBinomeRecues = new ArrayList<>();
}
