package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Action;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.ActionRepository;

import com.BanqueBlood.Banque_Blood.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ActionServiceImp implements ActionService {
    @Autowired
    ActionRepository actionRepository;

    @Override
    public Action ajoutAction(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public List<Action> afficherListAction() {
        return actionRepository.findAll();
    }

    @Override
    public void supprimerAction(Long id) {
        actionRepository.deleteById(id);

    }

    @Override
    public Action modifierAction(Action action, Long id) {
        return actionRepository.findById(id).get();
    }

    @Override
    public Action afficherActionById(Long id) {
        return actionRepository.findById(id).get();
    }

    public void addAction(Utilisateur utilisateur, String action, String nomComplet, LocalDate date){
        Action action1 = new Action();
        action1.setUtilisateur(utilisateur);
        action1.setAction(action);
        action1.setDate(date);
        action1.setNomComplet(nomComplet);
        actionRepository.save(action1);
    }







}
