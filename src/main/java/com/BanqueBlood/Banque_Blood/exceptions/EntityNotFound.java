package com.BanqueBlood.Banque_Blood.exceptions;

public class EntityNotFound extends  RuntimeException{
    private  ErrorsCode errorsCode;
    public  EntityNotFound(String message){super(message);}
    public EntityNotFound(String message, Throwable cause){
        super(message,cause);
    }
    public EntityNotFound(String message, Throwable cause, ErrorsCode errorsCode){
        super(message, cause);
        this.errorsCode=errorsCode;
    }
    public  EntityNotFound(String message, ErrorsCode errorsCode){
        super(message);
        this.errorsCode=errorsCode;
    }

    public ErrorsCode getErrorsCode() {
        return errorsCode;
    }
}
