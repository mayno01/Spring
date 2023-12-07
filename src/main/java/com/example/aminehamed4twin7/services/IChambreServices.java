package com.example.aminehamed4twin7.services;



import com.example.aminehamed4twin7.entities.Chambre;

import java.util.List;

public interface IChambreServices {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    Chambre retrieveChambre(long idChambre);
}

