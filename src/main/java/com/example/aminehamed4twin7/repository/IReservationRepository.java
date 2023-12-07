package com.example.aminehamed4twin7.repository;

// IReservationRepository.java

import com.example.aminehamed4twin7.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}

