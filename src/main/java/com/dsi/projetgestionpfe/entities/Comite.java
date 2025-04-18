package com.dsi.projetgestionpfe.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    @ManyToMany
    @JoinTable(
            name = "comite_enseignant",
            joinColumns = @JoinColumn(name = "comite_id"),
            inverseJoinColumns = @JoinColumn(name = "enseignant_id")
    )
    private List<Enseignant> enseignants;
}
