package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Rapport;
import com.dsi.projetgestionpfe.services.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rapports")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @GetMapping
    public List<Rapport> getAllRapports() {
        return rapportService.getAllRapports();
    }

    @GetMapping("/{id}")
    public Rapport getRapportById(@PathVariable int id) {
        return rapportService.getRapportById(id);
    }

    @PostMapping("/addRapport")
    public Rapport addRapport(@RequestBody Rapport rapport) {
        return rapportService.createRapport(rapport);
    }

    @PutMapping("/updateRapport/{id}")
    public Rapport updateRapport(@PathVariable int id, @RequestBody Rapport rapport) {
        rapport.setIdDoc(id);
        return rapportService.updateRapport(rapport);
    }

    @DeleteMapping("/deleteRapport/{id}")
    public void deleteRapport(@PathVariable int id) {
        rapportService.deleteRapport(id);
    }
}