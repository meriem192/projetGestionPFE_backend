package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.LoginRequest;
import com.dsi.projetgestionpfe.entities.Utilisateur;
import com.dsi.projetgestionpfe.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Utilisateur login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}

