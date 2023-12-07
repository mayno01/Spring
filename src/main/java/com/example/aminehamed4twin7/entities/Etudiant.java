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
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    private Date dateNaissance;
    private long capaciteFoyer;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "idEtudiant"),
            inverseJoinColumns = @JoinColumn(name = "idReservation"))
    private Set<Reservation> reservations = new HashSet<>();
}
