package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Action;

import com.BanqueBlood.Banque_Blood.model.GroupeSanguin;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.ActionRepository;

import com.BanqueBlood.Banque_Blood.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Action foundAction = actionRepository.findById(id).get();
        foundAction.setNomComplet(action.getNomComplet());
        foundAction.setAction(action.getAction());
        foundAction.setAccept(action.isAccept());
        foundAction.setDate(action.getDate());
        foundAction.setNbrepoche(action.getNbrepoche());
        foundAction.setAccepteur(action.getAccepteur());
        foundAction.setGroupeSanguin(action.getGroupeSanguin());
        foundAction.setAdmin(action.getAdmin());
        return actionRepository.save(foundAction);
    }

    @Override
    public Action afficherActionById(Long id) {
        return actionRepository.findById(id).get();
    }

    public void addAction(Utilisateur utilisateur, String action, String nomComplet, GroupeSanguin groupeSanguin, LocalDate date){
        Action action1 = new Action();
        action1.setUtilisateur(utilisateur);
        action1.setAction(action);
        action1.setDate(date);
        action1.setNomComplet(nomComplet);
        action1.setGroupeSanguin(groupeSanguin);
        actionRepository.save(action1);
    }

    public Action updateAction(String action, Utilisateur utilisateur, String nomComplet, Long id, GroupeSanguin groupeSanguin, LocalDate date) {
        Optional<Action> actionFound = actionRepository.findActionByDateAndUtilisateur(id);
        actionFound.get().setAction(action);
        actionFound.get().setUtilisateur(utilisateur);
        actionFound.get().setNomComplet(nomComplet);
        actionFound.get().setDate(date);
        actionFound.get().setGroupeSanguin(groupeSanguin);
        actionFound.get().setAccept(true);

        return actionRepository.save(actionFound.get());
    }







}
