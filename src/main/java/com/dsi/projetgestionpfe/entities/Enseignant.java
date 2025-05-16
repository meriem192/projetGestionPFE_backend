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
public class Enseignant extends Utilisateur {
    private String specialite;
    @ElementCollection
    @CollectionTable(
            name = "jury_enseignants",
            joinColumns = @JoinColumn(name = "enseigant_id")
    )
    private List<EnseignantJury> enseignantsJury = new ArrayList<>();

    @ManyToMany(mappedBy = "enseignants")
    private List<Comite> comites = new ArrayList<>();


}
