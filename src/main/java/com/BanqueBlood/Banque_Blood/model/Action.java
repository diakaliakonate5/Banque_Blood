package com.BanqueBlood.Banque_Blood.model;

import com.BanqueBlood.Banque_Blood.Profils;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDate date = LocalDate.now();
    private String action;
    private String nomComplet;
    private int nbrepoche;
    private Profils profils;
    private String status;

    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Utilisateur accepteur;
    private boolean accept = false;
    @ManyToOne
    private  GroupeSanguin groupeSanguin;
    @ManyToOne
    private Admin admin;



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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public int getNbrepoche() {
        return nbrepoche;
    }

    public void setNbrepoche(int nbrepoche) {
        this.nbrepoche = nbrepoche;
    }

    public Utilisateur getAccepteur() {
        return accepteur;
    }

    public void setAccepteur(Utilisateur accepteur) {
        this.accepteur = accepteur;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public GroupeSanguin getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(GroupeSanguin groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public Profils getProfils() {
        return profils;
    }

    public void setProfils(Profils profils) {
        this.profils = profils;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
