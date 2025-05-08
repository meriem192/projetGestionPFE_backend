package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDoc;
    private byte[] contenu;
    private Statut statut;
    private LocalDate dateSoumission;
    @ManyToOne
    @JoinColumn(name = "pfe_id")
    private Pfe pfe;
}
