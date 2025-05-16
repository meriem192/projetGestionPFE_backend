package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Etudiant;
import com.dsi.projetgestionpfe.entities.Parcours;
import com.dsi.projetgestionpfe.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable int id) {
        return etudiantService.getEtudiantById(id);
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) {
        etudiant.setId(id);
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable int id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/parcours")
    public List<Etudiant> findByParcours(@RequestParam Parcours parcours) {
        return etudiantService.findByParcours(parcours);
    }
}