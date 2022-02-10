package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Admin;

import java.util.List;

public interface AdminService {
    Admin ajoutAdmin(Admin admin);
    List<Admin> afficherListAdmin();
    void supprimerAdmin(Long id);
    Admin modifierAdmin(Admin admin, Long id);
    Admin afficherAdminById(Long id);
    String modifierPassword(Long id, String nouveauPassword);
    Admin connexion(String login, String password);

}
