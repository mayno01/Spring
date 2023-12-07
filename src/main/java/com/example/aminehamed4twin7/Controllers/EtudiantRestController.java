package com.example.aminehamed4twin7.Controllers;

// EtudiantRestController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.aminehamed4twin7.entities.Etudiant;
import com.example.aminehamed4twin7.services.IEtudiantServices;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantRestController {

    @Autowired
    private IEtudiantServices etudiantServices;

    @GetMapping("/all")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantServices.retrieveAllEtudiants();
    }

    @PostMapping("/add")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantServices.addEtudiants(etudiants);
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServices.updateEtudiant(etudiant);
    }

    @GetMapping("/{id}")
    public Etudiant retrieveEtudiant(@PathVariable long id) {
        return etudiantServices.retrieveEtudiant(id);
    }

    @DeleteMapping("/{id}")
    public void removeEtudiant(@PathVariable long id) {
        etudiantServices.removeEtudiant(id);
    }
}

