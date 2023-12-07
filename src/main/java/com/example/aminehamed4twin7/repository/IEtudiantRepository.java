package com.example.aminehamed4twin7.repository;

// IEtudiantRepository.java

import com.example.aminehamed4twin7.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
}

