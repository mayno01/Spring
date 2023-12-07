package com.example.aminehamed4twin7.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;

    @ManyToOne
    @JoinColumn(name = "idBloc")
    private Bloc bloc;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> Reservations;
}
