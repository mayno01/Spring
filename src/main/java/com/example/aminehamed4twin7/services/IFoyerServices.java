package com.example.aminehamed4twin7.services;

import com.example.aminehamed4twin7.entities.Foyer;

import java.util.List;

public interface IFoyerServices {
    List<Foyer> retrieveAllFoyers();
    List<Foyer> addFoyers(List<Foyer> foyers);
    Foyer updateFoyer(Foyer foyer);
    Foyer retrieveFoyer(long idFoyer);
    void removeFoyer(long idFoyer);


    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

}
