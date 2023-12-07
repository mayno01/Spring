package com.example.aminehamed4twin7.services;



import com.example.aminehamed4twin7.entities.Bloc;
import com.example.aminehamed4twin7.entities.Foyer;
import com.example.aminehamed4twin7.entities.Universite;
import com.example.aminehamed4twin7.repository.IFoyerRepository;
import com.example.aminehamed4twin7.repository.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
@Aspect
@Service
@RequiredArgsConstructor


public class UniversiteServicesImpl implements IUniversiteServices {

    final IFoyerRepository ifoyerRepository;

    @Autowired
    private IUniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(long id, Universite universite) {
        Universite existingUniversite = universiteRepository.findById(id).orElse(null);

        if (existingUniversite != null) {

            existingUniversite.setNomUniversite(universite.getNomUniversite());
            existingUniversite.setAdresse(universite.getAdresse());


            return universiteRepository.save(existingUniversite);
        } else {

            return null;
        }
    }


    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }
    @Transactional
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = ifoyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (foyer != null && universite != null) {
            universite.setFoyer(foyer);
            foyer.setUniversite(universite);

            // Save changes to persist the relationship
            universiteRepository.save(universite);
            ifoyerRepository.save(foyer);
        }

        return universite;
    }
    @Override
    public void deleteUniversite(long idUniversite) {

        if (universiteRepository.existsById(idUniversite)) {
            universiteRepository.deleteById(idUniversite);
        }
    }
    @Transactional
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {

            universite.setFoyer(null);

            universiteRepository.save(universite);
        }

        return universite;
    }





}
