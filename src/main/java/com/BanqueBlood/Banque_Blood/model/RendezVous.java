package com.BanqueBlood.Banque_Blood.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String lieu;
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany
    private List<BanqueSang> banqueSang;
}
