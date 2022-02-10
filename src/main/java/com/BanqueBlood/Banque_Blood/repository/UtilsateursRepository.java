package com.BanqueBlood.Banque_Blood.repository;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilsateursRepository extends JpaRepository <Utilisateur, Long> {
    Optional<Utilisateur> findByTelephoneAndPassword(String telephone, String password);
}
