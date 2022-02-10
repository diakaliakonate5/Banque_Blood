package com.BanqueBlood.Banque_Blood.repository;

import com.BanqueBlood.Banque_Blood.model.BanqueSang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanqueSangRepository extends JpaRepository <BanqueSang, Long> {
}
