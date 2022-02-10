package com.BanqueBlood.Banque_Blood.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String Prenom;

    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false, unique = true)
    private int telephone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @OneToMany
    private List<Utilisateur> Utilisateur;
    @OneToMany
    private List<Action> actions;

    public Admin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<com.BanqueBlood.Banque_Blood.model.Utilisateur> getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(List<com.BanqueBlood.Banque_Blood.model.Utilisateur> utilisateur) {
        Utilisateur = utilisateur;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getMotDePasse() {
        return password;
    }

    public void setMotDePasse(String password) {
        this.password = password;
    }
}
