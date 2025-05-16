package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Etudiant;
import com.dsi.projetgestionpfe.entities.Utilisateur;

import java.util.List;


public interface UserService {
    Utilisateur login(String email, String password);
    Utilisateur addUtilisateur(Utilisateur utilisateur);
    List<Utilisateur> getUtilisateurs();
    boolean deleteUser(int id);
}
