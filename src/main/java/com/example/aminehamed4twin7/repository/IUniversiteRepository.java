package com.example.aminehamed4twin7.repository;

// IUniversityRepository.java

import com.example.aminehamed4twin7.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    Universite findByNomUniversite(String nom);

}

