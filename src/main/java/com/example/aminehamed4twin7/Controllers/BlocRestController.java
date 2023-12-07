package com.example.aminehamed4twin7.Controllers;

// BlocRestController.java

import com.example.aminehamed4twin7.entities.Chambre;
import com.example.aminehamed4twin7.services.IBlocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.aminehamed4twin7.entities.Bloc;
import com.example.aminehamed4twin7.services.BlocServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocRestController {

    @Autowired
    private IBlocServices blocServices;

    @GetMapping("/all")
    public List<Bloc> retrieveBlocs() {
        return blocServices.retrieveBlocs();
    }

    @PutMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocServices.updateBloc(bloc);
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocServices.addBloc(bloc);
    }

    @GetMapping("/{id}")
    public Bloc retrieveBloc(@PathVariable long id) {
        return blocServices.retrieveBloc(id);
    }

    @DeleteMapping("/{id}")
    public void removeBloc(@PathVariable long id) {
        blocServices.removeBloc(id);
    }


    @PutMapping("/assign-chambres/{blocId}")
    public ResponseEntity<Bloc> assignChambresToBloc(@RequestBody List<Long> numeroChambres,
                                                     @PathVariable("blocId") long blocId) {
        Bloc assignedBloc = blocServices.affecterChambresABloc(numeroChambres, blocId);

        if (assignedBloc != null) {
            return new ResponseEntity<>(assignedBloc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/affecterBlocAFoyer/{idBloc}/{idFoyer}")
    public  Bloc affecterBlocAFoyer (@PathVariable long idBloc , @PathVariable long idFoyer){
        return blocServices.affecterBlocAFoyer(idBloc,idFoyer);
    }
}
