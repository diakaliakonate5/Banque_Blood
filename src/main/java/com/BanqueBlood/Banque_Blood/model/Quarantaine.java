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
    @ManyToOne
    private Utilisateur utilisateur ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
