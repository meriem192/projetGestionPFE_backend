package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Pfe;
import com.dsi.projetgestionpfe.entities.Statut;
import com.dsi.projetgestionpfe.services.PfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pfes")
public class PfeController {

    @Autowired
    private PfeService pfeService;

    @GetMapping
    public List<Pfe> getAllPfes() {
        return pfeService.getAllPfe();
    }

    @GetMapping("/{id}")
    public Pfe getPfeById(@PathVariable int id) {
        return pfeService.getPfeById(id);
    }

    @PostMapping("/addPfe")
    public Pfe addPfe(@RequestBody Pfe pfe) {
        return pfeService.createPfe(pfe);
    }

    @PutMapping("/updatePfe/{id}")
    public Pfe updatePfe(@PathVariable int id, @RequestBody Pfe pfe) {
        pfe.setId(id);
        return pfeService.updatePfe(pfe);
    }

    @DeleteMapping("/deletePfe/{id}")
    public void deletePfe(@PathVariable int id) {
        pfeService.deletePfe(id);
    }

    @GetMapping("/statut")
    public List<Pfe> getPfeByStatut(@RequestParam Statut statut) {
        return pfeService.getPfeByStatut(statut);
    }

    @GetMapping("/jury/{juryId}")
    public List<Pfe> getPfeByJury(@PathVariable int juryId) {
        return pfeService.getPfeByJury(juryId);
    }
}