package com.BanqueBlood.Banque_Blood.controller;

import com.BanqueBlood.Banque_Blood.model.BanqueSang;
import com.BanqueBlood.Banque_Blood.services.BanqueSangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Banque")
public class BanqueSangController {
    @Autowired
    BanqueSangService banqueSangService;
    @PostMapping("/Ajout")
    BanqueSang Ajout(@RequestBody BanqueSang banqueSang){
        return  banqueSangService.ajoutBanque(banqueSang);

    }
    @GetMapping("/listBanque")
    List<BanqueSang> listBanque()                  {
        return banqueSangService.listBanque();
    }
    @GetMapping("/ById/{id}")
    BanqueSang Banquebyid(@PathVariable("id") Long id){
        return  banqueSangService.afficherbyid(id);
    }
    @DeleteMapping("/suprimerBanque/{id}")
    void supprimerBanque(@PathVariable("id") Long id){
        banqueSangService.suprimer(id);
    }
    @PutMapping("/modifierBanque/{id}")
    BanqueSang modifierBanque(@PathVariable("id")Long id, @RequestBody BanqueSang banqueSang){
        return banqueSangService.modifier(banqueSang, id);
    }

}
