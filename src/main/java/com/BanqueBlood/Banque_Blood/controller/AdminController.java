package com.BanqueBlood.Banque_Blood.controller;

import com.BanqueBlood.Banque_Blood.model.Admin;

import com.BanqueBlood.Banque_Blood.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/Ajout")
    Admin Ajout(@RequestBody Admin admin){
        return  adminService.ajoutAdmin(admin);
    }
    @GetMapping("/listAdmins")
    List<Admin> listAdmin()                  {
        return adminService.afficherListAdmin();
    }
    @GetMapping("/ById/{id}")
    Admin AdminById(@PathVariable("id") Long id){
        return  adminService.afficherAdminById(id);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    void deleteAdmin(@PathVariable("id")Long id){
        adminService.supprimerAdmin(id);
    }
    @PutMapping("/modifierAdmin/{id}")
    Admin modifierAdmin(@PathVariable("id")Long id, @RequestBody Admin admin){
        return adminService.modifierAdmin(admin, id);
    }


}
