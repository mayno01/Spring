package com.example.aminehamed4twin7.Controllers;


import com.example.aminehamed4twin7.entities.Reservation;
import com.example.aminehamed4twin7.services.IReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    @Autowired
    private IReservationServices reservationServices;

    @GetMapping("/all")
    public List<Reservation> retrieveAllReservations() {
        return reservationServices.retrieveAllReservations();
    }

    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationServices.updateReservation(reservation);
    }

    @GetMapping("/{id}")
    public Reservation retrieveReservation(@PathVariable long id) {
        return reservationServices.retrieveReservation(id);
    }
}

