package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Utilisateur;
import com.dsi.projetgestionpfe.services.UserService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public Utilisateur addUser(@RequestBody Utilisateur user) {
        return userService.addUtilisateur(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
