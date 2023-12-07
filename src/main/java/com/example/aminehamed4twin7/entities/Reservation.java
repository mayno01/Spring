package com.example.aminehamed4twin7.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiants = new HashSet<>();
}
