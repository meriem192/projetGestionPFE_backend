package com.dsi.projetgestionpfe.services;

import com.dsi.projetgestionpfe.entities.Utilisateur;
import com.dsi.projetgestionpfe.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UtilisateurRepository userRepository;
    @Override
    public Utilisateur login(String email, String password) {
        Optional<Utilisateur> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional.get();
        }
        return null;
    }
}
