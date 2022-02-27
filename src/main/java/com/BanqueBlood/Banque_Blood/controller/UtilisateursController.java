package com.BanqueBlood.Banque_Blood.controller;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Utilisateur")
public class UtilisateursController {
    @Autowired
    UtilisateurService utilisateurService;
    @PostMapping("/Ajout")
    Utilisateur Ajout(@RequestBody Utilisateur utilisateur){
        return  utilisateurService.ajoutUtilisateur(utilisateur);

    }
    @GetMapping("/listUtilisateur")
    List<Utilisateur> listUtilisateur()                  {
        return utilisateurService.listUtilisateur();
    }
    @GetMapping("/ById/{id}")
    Utilisateur Utilisateurbyid(@PathVariable("id") Long id){
        return  utilisateurService.afficherbyid(id);
    }
    @DeleteMapping("/suprimerUtilisateur/{id}")
    void supprimerDonneur(@PathVariable("id") Long id){
        utilisateurService.suprimer(id);
    }
    @PutMapping("/modifierUtilisateur/{id}")
    Utilisateur modifierDonneur(@PathVariable("id")Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.modifier(utilisateur, id);
    }

    @GetMapping("/login/{telephone}/{password}")
    public Utilisateur login (@PathVariable String telephone, @PathVariable String password){
        return  utilisateurService.login(telephone, password);
    }
}
