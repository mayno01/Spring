package com.example.aminehamed4twin7.services;



import com.example.aminehamed4twin7.entities.Reservation;

import java.util.List;

public interface IReservationServices {
    List<Reservation> retrieveAllReservations();
    Reservation updateReservation(Reservation reservation);
    Reservation retrieveReservation(long idReservation);
}

