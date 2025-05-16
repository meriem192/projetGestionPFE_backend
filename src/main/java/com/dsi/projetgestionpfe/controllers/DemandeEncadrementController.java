package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.DemandeEncadrement;
import com.dsi.projetgestionpfe.entities.Statut;
import com.dsi.projetgestionpfe.services.DemandeEncadrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/demandes-encadrement")
public class DemandeEncadrementController {

    @Autowired
    private DemandeEncadrementService demandeService;

    @GetMapping
    public List<DemandeEncadrement> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    @GetMapping("/{id}")
    public DemandeEncadrement getDemandeById(@PathVariable int id) {
        return demandeService.getDemandeById(id);
    }

    @PostMapping("/addDemande")
    public DemandeEncadrement addDemande(@RequestBody DemandeEncadrement demande) {
        return demandeService.createDemande(demande);
    }

    @PutMapping("/updateDemande/{id}")
    public DemandeEncadrement updateDemande(@PathVariable int id, @RequestBody DemandeEncadrement demande) {
        demande.setId(id);
        return demandeService.updateDemande(demande);
    }

    @DeleteMapping("/deleteDemande/{id}")
    public void deleteDemande(@PathVariable int id) {
        demandeService.deleteDemande(id);
    }

    @GetMapping("/etudiant/{etudiantId}")
    public List<DemandeEncadrement> getDemandesByEtudiant(@PathVariable int etudiantId) {
        return demandeService.getDemandesByEtudiant(etudiantId);
    }

    @GetMapping("/enseignant/{enseignantId}")
    public List<DemandeEncadrement> getDemandesByEnseignant(@PathVariable int enseignantId) {
        return demandeService.getDemandesByEnseignant(enseignantId);
    }

    @GetMapping("/statut")
    public List<DemandeEncadrement> getDemandesByStatut(@RequestParam Statut statut) {
        return demandeService.getDemandesByStatut(statut);
    }
}