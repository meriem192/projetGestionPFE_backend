package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    @ManyToOne
    private Utilisateur destinataire;
    private boolean lue;

    @ManyToOne
    private Utilisateur emetteur;

}
