package com.example.aminehamed4twin7.Controllers;

// ChambreRestController.java

import com.example.aminehamed4twin7.entities.Chambre;
import com.example.aminehamed4twin7.services.IChambreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreRestController {

    @Autowired
    private IChambreServices chambreServices;

    @GetMapping("/all")
    public List<Chambre> retrieveAllChambres() {
        return chambreServices.retrieveAllChambres();
    }

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreServices.addChambre(chambre);
    }

    @PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreServices.updateChambre(chambre);
    }

    @GetMapping("/{id}")
    public Chambre retrieveChambre(@PathVariable long id) {
        return chambreServices.retrieveChambre(id);
    }
}
