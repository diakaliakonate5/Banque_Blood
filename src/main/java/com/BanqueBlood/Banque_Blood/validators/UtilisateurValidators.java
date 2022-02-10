package com.BanqueBlood.Banque_Blood.validators;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidators
{
    public static List<String> validate(Utilisateur utilisateur){
        List<String> errors = new ArrayList<>();
        if(utilisateur==null){
            errors.add("veuillez renseigner le champ Nom Complet");
            errors.add("veuillez renseigner le champ telephone svp!");
            errors.add("veuillez renseigner le champ password svp!");
            errors.add("veuillez renseigner le champ adresse svp!");
            errors.add("veuillez renseigner le champ email svp!");
            return  errors;
        }


        if(!StringUtils.hasLength(utilisateur.getNomComplet()))
        {
            errors.add("le nom complet svp");
        }
        if(!StringUtils.hasLength(utilisateur.getTelephone()))
        {
            errors.add("le telephone svp");
        }
         if(!StringUtils.hasLength(utilisateur.getPassword()))
    {
        errors.add("le mot de passe svp");
    }
          if(!StringUtils.hasLength(utilisateur.getAdresse()))
    {
        errors.add("Adresse svp");
    }
           if(!StringUtils.hasLength(utilisateur.getEmail()))
    {
        errors.add("l'email' svp");
    }
           return errors;
    }
}

