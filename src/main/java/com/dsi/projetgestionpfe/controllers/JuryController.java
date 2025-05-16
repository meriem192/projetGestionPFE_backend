package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Jury;
import com.dsi.projetgestionpfe.services.JuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/jurys")
public class JuryController {

    @Autowired
    private JuryService juryService;

    @GetMapping
    public List<Jury> getAllJurys() {
        return juryService.getAllJury();
    }

    @GetMapping("/{id}")
    public Jury getJuryById(@PathVariable int id) {
        return juryService.getJuryById(id);
    }

    @PostMapping("/addJury")
    public Jury addJury(@RequestBody Jury jury) {
        return juryService.createJury(jury);
    }

    @PutMapping("/updateJury/{id}")
    public Jury updateJury(@PathVariable int id, @RequestBody Jury jury) {
        jury.setId(id);
        return juryService.updateJury(jury);
    }

    @DeleteMapping("/deleteJury/{id}")
    public void deleteJury(@PathVariable int id) {
        juryService.deleteJury(id);
    }
}