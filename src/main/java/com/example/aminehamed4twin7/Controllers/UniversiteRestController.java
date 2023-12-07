package com.example.aminehamed4twin7.Controllers;



import com.example.aminehamed4twin7.entities.Universite;
import com.example.aminehamed4twin7.services.IUniversiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
@CrossOrigin(origins = "http://localhost:4200",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        allowedHeaders = {"Authorization", "Content-Type"},
        allowCredentials = "true")

public class UniversiteRestController {

    @Autowired
    private IUniversiteServices universiteServices;

    @GetMapping("/all")
    public List<Universite> retrieveAllUniversities() {
        return universiteServices.retrieveAllUniversities();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteServices.addUniversite(universite);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable("id") long id, @RequestBody Universite universite) {
        Universite existingUniversite = universiteServices.retrieveUniversite(id);

        if (existingUniversite != null) {
            universite.setIdUniversite(id);
            Universite updatedUniversite = universiteServices.updateUniversite(id, universite);
            return new ResponseEntity<>(updatedUniversite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public Universite retrieveUniversite(@PathVariable long id) {
        return universiteServices.retrieveUniversite(id);
    }



    @PutMapping("/{idFoyer}/assign/{universityName}")
    public ResponseEntity<String> assignFoyerToUniversity(@PathVariable Long idFoyer, @PathVariable String universityName) {
        Universite universite = universiteServices.affecterFoyerAUniversite(idFoyer, universityName);

        if (universite != null) {
            return ResponseEntity.ok("Foyer assigned to University successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Foyer or University not found");
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable long id) {
        universiteServices.deleteUniversite(id);
    }

    @PutMapping("/des/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite ){
        return universiteServices.desaffecterFoyerAUniversite(idUniversite);
    }
}

