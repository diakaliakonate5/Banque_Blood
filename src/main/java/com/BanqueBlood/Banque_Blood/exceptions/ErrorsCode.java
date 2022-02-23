package com.BanqueBlood.Banque_Blood.exceptions;

public enum ErrorsCode {
    UTILISATEUR_NON_TROUVE(1000),
    UTILISATEUR_NON_VALID(1001),
    UTILISATEUR_EXIST_DEJA(10002),
    UTILISATEUR_AUTHENTIFICATION_INVALID(1003),
    DON_INVALID(2000);


    private int code;

    ErrorsCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
