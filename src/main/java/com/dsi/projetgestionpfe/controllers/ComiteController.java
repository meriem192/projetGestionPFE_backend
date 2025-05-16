package com.dsi.projetgestionpfe.controllers;

import com.dsi.projetgestionpfe.entities.Comite;
import com.dsi.projetgestionpfe.services.ComiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/comites")
public class ComiteController {

    @Autowired
    private ComiteService comiteService;

    @GetMapping
    public List<Comite> getAllComites() {
        return comiteService.getComites();
    }

    @GetMapping("/{id}")
    public Comite getComiteById(@PathVariable int id) {
        return comiteService.getComiteById(id);
    }

    @PostMapping("/addComite")
    public Comite addComite(@RequestBody Comite comite) {
        return comiteService.createComite(comite);
    }

    @PutMapping("/updateComite/{id}")
    public Comite updateComite(@PathVariable int id, @RequestBody Comite comite) {
        comite.setId(id);
        return comiteService.updateComite(comite);
    }

    @DeleteMapping("/deleteComite/{id}")
    public void deleteComite(@PathVariable int id) {
        comiteService.deleteComite(id);
    }
}