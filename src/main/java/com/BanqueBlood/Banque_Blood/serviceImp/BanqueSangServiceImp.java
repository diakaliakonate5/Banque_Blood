package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.BanqueSang;
import com.BanqueBlood.Banque_Blood.repository.BanqueSangRepository;
import com.BanqueBlood.Banque_Blood.services.BanqueSangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BanqueSangServiceImp  implements BanqueSangService {
    @Autowired
    BanqueSangRepository banqueSangRepository;

    @Override
    public BanqueSang ajoutBanque(BanqueSang banqueSang) {
        return banqueSangRepository.save(banqueSang);
    }

    @Override
    public List<BanqueSang> listBanque() {
        return banqueSangRepository.findAll();
    }

    @Override
    public BanqueSang afficherbyid(Long id) {
        return banqueSangRepository.findById(id).get();
    }

    @Override
    public BanqueSang modifier(BanqueSang banqueSang, Long id) {
        BanqueSang banqueSang1=banqueSangRepository.findById(id).get();
        banqueSang1.setNom(banqueSang.getNom());
        banqueSang1.setAdresse(banqueSang.getAdresse());
        banqueSang1.setTelephone(banqueSang.getTelephone());
        banqueSang1.setEmail(banqueSang.getEmail());


        return banqueSangRepository.save(banqueSang);
    }

    @Override
    public void suprimer(Long id) {
        banqueSangRepository.deleteById(id);
    }
}
