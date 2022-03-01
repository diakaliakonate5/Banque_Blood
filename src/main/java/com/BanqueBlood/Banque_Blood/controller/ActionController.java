package com.BanqueBlood.Banque_Blood.controller;

import com.BanqueBlood.Banque_Blood.model.Action;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.serviceImp.ActionServiceImp;
import com.BanqueBlood.Banque_Blood.serviceImp.UtilisateursServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Action")
public class ActionController {
    @Autowired
    UtilisateursServiceImp utilisateursServiceImp;
    @Autowired
    ActionServiceImp actionServiceImp;
    @PostMapping("/Ajout")
    Action Ajout(@RequestBody Action action){
        return  actionServiceImp.ajoutAction(action);
    }
    @GetMapping("/listAction")
    List<Action> listAction()                  {
        return actionServiceImp.afficherListAction();
    }
    @GetMapping("/ById/{id}")
    Action ActionById(@PathVariable("id") Long id){
        return  actionServiceImp.afficherActionById(id);
    }


    @DeleteMapping("/deleteAction{id}")
    void deleteAction(@PathVariable("id")Long id){
        actionServiceImp.supprimerAction(id);
    }
    @PutMapping("/modifierAction/{id}")
    Action modifierAction(@PathVariable("id")Long id, @RequestBody Action action){
        return actionServiceImp.modifierAction(action, id);
    }

    @GetMapping("/accepte/{idAccepteur}/{id}")
    void addAction(@PathVariable("idAccepteur") Long idAccepteur, @PathVariable("id") Long id){
        utilisateursServiceImp.addAlert(idAccepteur, id );
    }

}