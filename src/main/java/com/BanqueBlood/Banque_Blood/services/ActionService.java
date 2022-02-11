package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Action;


import java.util.List;

public interface ActionService {
    Action ajoutAction(Action action);
    List<Action> afficherListAction();
    void supprimerAction(Long id);
    Action modifierAction(Action action, Long id);
    Action afficherActionById(Long id);

}
