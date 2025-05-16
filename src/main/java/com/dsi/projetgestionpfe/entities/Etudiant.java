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
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @Enumerated(EnumType.STRING)
    private Parcours parcours;

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

    @ManyToOne
    @JoinColumn(name = "pfe_id")
    private Pfe pfe;


}
