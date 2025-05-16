package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.LoginRequest;
import com.dsi.projetgestionpfe.entities.Utilisateur;

public interface LoginService {
    Utilisateur login(LoginRequest loginRequest);
}
