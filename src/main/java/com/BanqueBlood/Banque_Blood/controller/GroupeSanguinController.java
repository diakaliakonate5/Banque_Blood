package com.BanqueBlood.Banque_Blood.controller;
import com.BanqueBlood.Banque_Blood.model.Admin;
import com.BanqueBlood.Banque_Blood.model.GroupeSanguin;
import com.BanqueBlood.Banque_Blood.services.GroupeSanguinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Groupe")
public class GroupeSanguinController {
    @Autowired
    GroupeSanguinService groupeSanguinService;
    @PostMapping("/Ajout")
    GroupeSanguin Ajout(@RequestBody GroupeSanguin groupeSanguin){
        return  groupeSanguinService.ajoutGroupe(groupeSanguin);
    }
    @GetMapping("/listGroupe")
    List<GroupeSanguin> listGroupe()                  {
        return groupeSanguinService.afficherListGroupe();
    }
    @GetMapping("/ById/{id}")
    GroupeSanguin GroupeById(@PathVariable("id") Long id){
        return  groupeSanguinService.afficherGroupeById(id);
    }

    @DeleteMapping("/deleteGroupe/{id}")
    void deleteGroupe(@PathVariable("id")Long id){
        groupeSanguinService.supprimerGroupe(id);
    }
    @PutMapping("/modifierGroupe/{id}")
    GroupeSanguin modifierGroupe(@PathVariable("id")Long id, @RequestBody GroupeSanguin groupeSanguin){
        return groupeSanguinService.modifierGroupe(groupeSanguin, id);
    }

}
