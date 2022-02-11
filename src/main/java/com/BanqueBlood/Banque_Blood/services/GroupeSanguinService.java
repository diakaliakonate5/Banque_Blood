package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Action;
import com.BanqueBlood.Banque_Blood.model.GroupeSanguin;

import java.util.List;

public interface GroupeSanguinService {


    GroupeSanguin ajoutGroupe(GroupeSanguin GroupeSanguin);
    List<GroupeSanguin> afficherListGroupe();
    void supprimerGroupe(Long id);
    GroupeSanguin modifierGroupe(GroupeSanguin groupeSanguin, Long id);
    GroupeSanguin afficherGroupeById(Long id);
}
