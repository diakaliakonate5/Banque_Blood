package com.BanqueBlood.Banque_Blood.repository;

import com.BanqueBlood.Banque_Blood.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ActionRepository extends JpaRepository<Action, Long> {

    //@Query(value = "SELECT act FROM Action act WHERE act.accept.id = :id AND act.accept = true")
    //Optional<Action> findActionByDateAndUtilisateur(@Param("id") Long id);


    Optional<Action> findByIdAndAccept(Long id, boolean accept);
}
