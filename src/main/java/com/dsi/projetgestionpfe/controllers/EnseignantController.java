package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Enseignant;
import com.dsi.projetgestionpfe.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getEnseignants();
    }

    @GetMapping("/{id}")
    public Enseignant getEnseignantById(@PathVariable int id) {
        return enseignantService.getEnseignantById(id);
    }
    @PostMapping("/addEnseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.addEnseignant(enseignant);
    }

    @PutMapping("/updateEnseignant/{id}")
    public Enseignant updateEnseignant(@PathVariable int id, @RequestBody Enseignant enseignant) {
        enseignant.setId(id);
        return enseignantService.updateEnseignant(enseignant);
    }

    @DeleteMapping("/deleteEnseignant/{id}")
    public void deleteEnseignant(@PathVariable int id) {
        enseignantService.deleteEnseignant(id);
    }
}