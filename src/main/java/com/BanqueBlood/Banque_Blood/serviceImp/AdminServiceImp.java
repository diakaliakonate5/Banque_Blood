package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Admin;
import com.BanqueBlood.Banque_Blood.repository.AdminRepository;
import com.BanqueBlood.Banque_Blood.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin ajoutAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
 @Override
    public Admin modifierAdmin(Admin admin, Long id) {
        Admin admin1 = adminRepository.findById(id).get();
        admin1.setPrenom(admin.getPrenom());
        admin1.setNom(admin.getNom());
        admin1.setAdresse(admin.getAdresse());
        admin1.setEmail(admin.getEmail());
        admin1.setMotDePasse(admin.getMotDePasse());
        admin1.setLogin(admin.getLogin());
        return  adminRepository.save(admin1);
    }
@Override
    public String modifierPassword(Long id, String nouveauPassword) {
        return null;
    }

@Override
    public List<Admin> afficherListAdmin() {
        return adminRepository.findAll();
    }
    @Override
    public void supprimerAdmin(Long id) {
        adminRepository.deleteById(id);
    }
    @Override
    public Admin afficherAdminById(Long id) {
        return adminRepository.findById(id).get();
    }
    @Override
    public Admin connexion(String login, String password) {
        Optional<Admin> adminConnexion = adminRepository.findByLoginAndPassword(login,password);
        return adminConnexion.orElse(null);
    }
}