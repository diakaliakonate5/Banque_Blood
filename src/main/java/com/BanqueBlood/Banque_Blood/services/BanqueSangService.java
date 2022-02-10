package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.BanqueSang;

import java.util.List;

public interface BanqueSangService {

    public BanqueSang ajoutBanque(BanqueSang banqueSang);
    List<BanqueSang> listBanque();
    BanqueSang afficherbyid(Long id);
    BanqueSang modifier(BanqueSang banqueSang , Long id);
    void suprimer(Long id);
}
