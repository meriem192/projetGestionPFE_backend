package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.LettreAffectation;
import com.dsi.projetgestionpfe.services.LettreAffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/lettres-affectation")
public class LettreAffectationController {

    @Autowired
    private LettreAffectationService lettreService;

    @GetMapping
    public List<LettreAffectation> getAllLettres() {
        return lettreService.getAllLettresAffectation();
    }

    @GetMapping("/{id}")
    public LettreAffectation getLettreById(@PathVariable int id) {
        return lettreService.getLettreAffectationById(id);
    }

    @PostMapping("/addLettre")
    public LettreAffectation addLettre(@RequestBody LettreAffectation lettre) {
        return lettreService.createLettreAffectation(lettre);
    }

    @PutMapping("/updateLettre/{id}")
    public LettreAffectation updateLettre(@PathVariable int id, @RequestBody LettreAffectation lettre) {
        lettre.setId(id);
        return lettreService.updateLettreAffectation(lettre);
    }

    @DeleteMapping("/deleteLettre/{id}")
    public void deleteLettre(@PathVariable int id) {
        lettreService.deleteLettreAffectation(id);
    }
}