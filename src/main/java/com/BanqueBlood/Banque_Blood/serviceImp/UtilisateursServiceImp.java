package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.Profils;
import com.BanqueBlood.Banque_Blood.exceptions.ErrorsCode;
import com.BanqueBlood.Banque_Blood.exceptions.InvalidEntity;

import com.BanqueBlood.Banque_Blood.model.Action;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.ActionRepository;
import com.BanqueBlood.Banque_Blood.repository.UtilsateursRepository;
import com.BanqueBlood.Banque_Blood.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursServiceImp  implements UtilisateurService  {
    @Autowired
    UtilsateursRepository utilsateursRepository ;

    @Autowired
    ActionServiceImp actionServiceImp;
    @Autowired
    ActionRepository actionRepository;

    @Override
    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur)


    {
        return utilsateursRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> listUtilisateur() {
        return utilsateursRepository.findAll();
    }



    @Override
    public Utilisateur afficherbyid(Long id) {
        return utilsateursRepository.findById(id).get();
    }

    @Override
    public Utilisateur modifier(Utilisateur utilisateur, Long id) {
        Utilisateur utilisateur1=utilsateursRepository.findById(id).get();
        utilisateur1.setNomComplet(utilisateur.getNomComplet());

        utilisateur1.setTelephone(utilisateur.getTelephone());
        utilisateur1.setEmail(utilisateur.getEmail());
        utilisateur1.setAdresse(utilisateur.getAdresse());
        utilisateur1.setPassword(utilisateur.getPassword());

        return utilsateursRepository.save(utilisateur1);
    }

    @Override
    public void suprimer(Long id) {
        utilsateursRepository.deleteById(id);
    }

    @Override
    public Utilisateur login(String telephone, String password) {
        Optional<Utilisateur> donneurConnexion = utilsateursRepository.findByTelephoneAndPassword(telephone,password);
   if(donneurConnexion.isEmpty()){
       throw new InvalidEntity("login ou mot de passe est incorrecte", ErrorsCode.UTILISATEUR_AUTHENTIFICATION_INVALID);
   }


        return donneurConnexion.get();
    }



    @Override
    public void addAlert(Utilisateur utilisateur, Long id) {
        Utilisateur utilisateurFound = utilsateursRepository.findById(id).get();

        Optional<Action> action = actionRepository.findActionByDateAndUtilisateur(id);

        if (action.isPresent()){
            int date = 0;
            LocalDate dateDebut = LocalDate.now();
            LocalDate dateFin = action.get().getDate();
            date = dateDebut.compareTo(dateFin);
            if (date <= -3){
                if (utilisateurFound.getProfils() == Profils.DONNEUR){
                    utilisateurFound.setProfils(Profils.PATIENT);
                }else {
                    utilisateurFound.setProfils(Profils.DONNEUR);
                }
                actionServiceImp.updateAction(utilisateurFound.getNomComplet()+" a crée une notification qu'il est un "+utilisateurFound.getProfils(),utilisateurFound,utilisateurFound.getNomComplet(), utilisateurFound.getId(), utilisateurFound.getGroupeSanguin(), LocalDate.now());
                utilsateursRepository.save(utilisateurFound);
            } else {
                throw new InvalidEntity("Vous ne pouvez pas faire un don! Votre dernier don ne vaut pas trois mois", ErrorsCode.DON_INVALID);
            }
        } else {
            if (utilisateurFound.getProfils() == Profils.DONNEUR){
                utilisateurFound.setProfils(Profils.PATIENT);
            }else {
                utilisateurFound.setProfils(Profils.DONNEUR);
            }
            actionServiceImp.addAction(utilisateurFound, utilisateurFound.getNomComplet()+" a crée une notification qu'il est un "+utilisateurFound.getProfils(), utilisateurFound.getNomComplet(), utilisateurFound.getGroupeSanguin(), LocalDate.now());
            utilsateursRepository.save(utilisateurFound);
        }
    }
}
