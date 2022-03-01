package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Action;
import com.BanqueBlood.Banque_Blood.model.Quarantaine;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;

import java.time.LocalDate;
import java.util.List;

public interface QuarantaineService  {
    Quarantaine  ajoutQuarantaine(LocalDate date, Long id);
    List<Quarantaine> afficherListQuarantaine();
    void supprimerQuarantaine(Long id);
    Quarantaine modifierQuarantaine(Action action, Long id);
    Quarantaine afficherQuarantaine(Long id);

}
