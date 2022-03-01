package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Action;
import com.BanqueBlood.Banque_Blood.model.Quarantaine;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.QuarantaineRepository;
import com.BanqueBlood.Banque_Blood.repository.UtilsateursRepository;
import com.BanqueBlood.Banque_Blood.services.QuarantaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Service
public class QuarantaineServiceImp implements QuarantaineService {
    @Autowired
    QuarantaineRepository quarantaineRepository;

    @Autowired
    UtilsateursRepository utilsateursRepository;

    @Transactional
    @Override
    public Quarantaine ajoutQuarantaine(LocalDate date, Long id  ) {
       Utilisateur utilisateur = utilsateursRepository.findById(id).get();
       utilisateur.setId(id);
       return null;
    }

    @Override
    public List<Quarantaine> afficherListQuarantaine() {
        return null;
    }

    @Override
    public void supprimerQuarantaine(Long id) {

    }

    @Override
    public Quarantaine modifierQuarantaine(Action action, Long id) {
        return null;
    }

    @Override
    public Quarantaine afficherQuarantaine(Long id) {
        return null;
    }

    Quarantaine addQuarantaine(LocalDate date, Quarantaine quarantaine, Long id){
        quarantaine.setDate(date);
        quarantaine.setUtilisateur(quarantaine.getUtilisateur());
        return quarantaineRepository.save(quarantaine);
    }
}
