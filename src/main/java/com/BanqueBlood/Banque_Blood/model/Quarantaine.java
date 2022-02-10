package com.BanqueBlood.Banque_Blood.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Quarantaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    LocalDate date = LocalDate.now();
    @OneToMany
    private List<Utilisateur> tUtilisateur;
    @ManyToOne
    private Utilisateur utilisateur ;
}
