package com.BanqueBlood.Banque_Blood.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class GroupeSanguin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String type;
   @OneToMany
    private List<Utilisateur> listUtilisateurs;


}
