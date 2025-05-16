package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.CahierDesCharges;
import com.dsi.projetgestionpfe.services.CahierDesChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cahiers-des-charges")
public class CahierDesChargesController {

    @Autowired
    private CahierDesChargesService cahierDesChargesService;

    @GetMapping
    public List<CahierDesCharges> getAllCahiersDesCharges() {
        return cahierDesChargesService.getAllCahiersDesCharges();
    }

    @GetMapping("/{id}")
    public CahierDesCharges getCahierDesChargesById(@PathVariable int id) {
        return cahierDesChargesService.getCahierDesChargesById(id);
    }

    @PostMapping("/addCahier")
    public CahierDesCharges addCahierDesCharges(@RequestBody CahierDesCharges cahierDesCharges) {
        return cahierDesChargesService.createCahierDesCharges(cahierDesCharges);
    }

    @PutMapping("/updateCahier/{id}")
    public CahierDesCharges updateCahierDesCharges(
            @PathVariable int id,
            @RequestBody CahierDesCharges cahierDesCharges) {
        cahierDesCharges.setId(id);
        return cahierDesChargesService.updateCahierDesCharges(cahierDesCharges);
    }

    @DeleteMapping("/deleteCahier/{id}")
    public void deleteCahierDesCharges(@PathVariable int id) {
        cahierDesChargesService.deleteCahierDesCharges(id);
    }
}