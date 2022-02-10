package com.BanqueBlood.Banque_Blood.exceptions;

import java.util.List;

public class InvalidEntity extends  RuntimeException {
    private ErrorsCode errorsCode;
    private List<String> errors;

    public InvalidEntity(String message){
        super(message);
    }

    public InvalidEntity(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidEntity(String message, Throwable cause, ErrorsCode errorCode){
        super(message, cause);
        this.errorsCode = errorCode;
    }

    public InvalidEntity(String message, ErrorsCode errorCode){
        super(message);
        this.errorsCode = errorCode;
    }

    public InvalidEntity(String message, ErrorsCode errorCode, List<String> errors){
        super(message);
        this.errorsCode = errorCode;
        this.errors = errors;
    }

    public ErrorsCode getErrorCode() {
        return errorsCode;
    }

    public List<String> getErrors() {
        return errors;
    }
}
