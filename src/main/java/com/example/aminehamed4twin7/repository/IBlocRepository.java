package com.example.aminehamed4twin7.repository;

// IBlocRepository.java

import com.example.aminehamed4twin7.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlocRepository extends JpaRepository<Bloc, Long> {

}

