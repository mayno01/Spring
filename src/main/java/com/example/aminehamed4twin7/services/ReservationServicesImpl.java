package com.example.aminehamed4twin7.services;



import com.example.aminehamed4twin7.entities.Reservation;
import com.example.aminehamed4twin7.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationServicesImpl implements IReservationServices {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
}

