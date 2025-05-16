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
public class Jury{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    @CollectionTable(
            name = "jury_enseignants",
            joinColumns = @JoinColumn(name = "jury_id")
    )
    private List<EnseignantJury> enseignantsJury = new ArrayList<>();
    @OneToMany(mappedBy = "jury")
    private List<Pfe> pfes;

}
