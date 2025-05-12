package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Utilisateur;

public interface UserService {
    Utilisateur login(String email, String password);
}
