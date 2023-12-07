package com.example.aminehamed4twin7.services;


import com.example.aminehamed4twin7.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite(Universite universite);
    public Universite updateUniversite(long id, Universite universite);
    Universite retrieveUniversite(long idUniversite);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public void deleteUniversite(long idUniversite);
    public Universite desaffecterFoyerAUniversite ( long idUniversite);
}

