package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.LoginRequest;
import com.dsi.projetgestionpfe.entities.Utilisateur;
import com.dsi.projetgestionpfe.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public Utilisateur login(LoginRequest loginRequest) {
        Optional<Utilisateur> optionalUser = utilisateurRepository.findByEmail(loginRequest.getEmail());

        if(optionalUser.isPresent()) {
            Utilisateur user = optionalUser.get();
            if(user.getPassword().equals(loginRequest.getPassword())) {
                return user;
            }
        }

        throw new RuntimeException("Email ou mot de passe incorrect");
    }
}
