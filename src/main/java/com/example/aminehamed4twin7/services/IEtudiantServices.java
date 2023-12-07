package com.example.aminehamed4twin7.services;


import com.example.aminehamed4twin7.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant updateEtudiant(Etudiant etudiant);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
}

