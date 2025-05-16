package com.dsi.projetgestionpfe.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {
    //PS: c'est pas une entité à part, juste une classe qui sert à transporter les données
    private String email;
    private String password;

}
