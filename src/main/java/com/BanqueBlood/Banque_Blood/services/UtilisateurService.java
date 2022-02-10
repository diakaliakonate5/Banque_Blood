package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur ajoutUtilisateur(Utilisateur utilisateur);
    List<Utilisateur> listUtilisateur();
    Utilisateur afficherbyid(Long id);
    Utilisateur modifier(Utilisateur utilisateur , Long id);
    void suprimer(Long id);
    Utilisateur login(String telephone, String password);





    void addAlert(Long id);


}
