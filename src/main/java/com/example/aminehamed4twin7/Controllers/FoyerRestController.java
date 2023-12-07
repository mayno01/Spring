package com.example.aminehamed4twin7.Controllers;

import com.example.aminehamed4twin7.entities.Foyer;
import com.example.aminehamed4twin7.entities.Universite;
import com.example.aminehamed4twin7.services.FoyerServicesImpl;
import com.example.aminehamed4twin7.services.IFoyerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyers")
@CrossOrigin(origins = "http://localhost:4200")
public class FoyerRestController {
    private final FoyerServicesImpl foyerService;

    @Autowired
    public FoyerRestController(FoyerServicesImpl foyerService) {
        this.foyerService = foyerService;
    }

    @Autowired
    private IFoyerServices foyerServices;

    @GetMapping("/all")
    public List<Foyer> retrieveAllFoyers() {
        return foyerServices.retrieveAllFoyers();
    }

    @PostMapping("/add")
    public List<Foyer> addFoyers(@RequestBody List<Foyer> foyers) {
        return foyerServices.addFoyers(foyers);
    }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerServices.updateFoyer(foyer);
    }

    @GetMapping("/{id}")
    public Foyer retrieveFoyer(@PathVariable long id) {
        return foyerServices.retrieveFoyer(id);
    }

    @DeleteMapping("/{id}")
    public void removeFoyer(@PathVariable long id) {
        foyerServices.removeFoyer(id);
    }


    @PostMapping("/add-and-assign-to-universite/{universiteId}")
    public ResponseEntity<Foyer> addFoyerAndAssignToUniversite(@RequestBody Foyer foyer,
                                                               @PathVariable("universiteId") long universiteId) {
        Foyer addedFoyer = foyerService.ajouterFoyerEtAffecterAUniversite(foyer, universiteId);

        if (addedFoyer != null) {
            return new ResponseEntity<>(addedFoyer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
