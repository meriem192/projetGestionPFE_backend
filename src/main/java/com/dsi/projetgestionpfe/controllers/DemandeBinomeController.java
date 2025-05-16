package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.DemandeBinome;
import com.dsi.projetgestionpfe.entities.Statut;
import com.dsi.projetgestionpfe.services.DemandeBinomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/demandes-binome")
public class DemandeBinomeController {

    @Autowired
    private DemandeBinomeService demandeBinomeService;

    @PostMapping("/envoyer/{sourceId}/{cibleId}")
    public Boolean envoyerDemandeBinome(
            @PathVariable int sourceId,
            @PathVariable int cibleId) {
        return  demandeBinomeService.envoyerDemandeBinome(sourceId, cibleId);
    }

    @PutMapping("/repondre/{sourceId}/{cibleId}")
    public void repondreDemandeBinome(
            @PathVariable int sourceId,
            @PathVariable int cibleId,
            @RequestParam Statut reponse) {
        demandeBinomeService.repondreDemandeBinome(sourceId, cibleId, reponse);
    }

    @GetMapping("/envoyees/{etudiantId}")
    public List<DemandeBinome> getDemandesEnvoyees(@PathVariable int etudiantId) {
            return demandeBinomeService.getDemandesEnvoyees(etudiantId);
    }

    @GetMapping("/recues/{etudiantId}")
    public List<DemandeBinome> getDemandesRecues(@PathVariable int etudiantId) {
            return demandeBinomeService.getDemandesRecues(etudiantId);
    }

    @GetMapping("/statut/{etudiantId}")
    public List<DemandeBinome> getDemandesByStatut(
            @PathVariable int etudiantId,
            @RequestParam Statut statut) {
            return demandeBinomeService.getDemandesByStatut(etudiantId, statut);
    }

}