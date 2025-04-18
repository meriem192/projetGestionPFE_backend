package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String commentaire;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "enseigant_id")
    private Enseignant enseignant;


}
