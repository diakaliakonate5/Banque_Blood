package com.BanqueBlood.Banque_Blood.handlerErrors;

import com.BanqueBlood.Banque_Blood.exceptions.ErrorsCode;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Error {
    private Integer httpCode;
    private ErrorsCode errorsCode;
    private String message;
    private List<String> errors = new ArrayList<>();

    public Error(Integer httpCode, ErrorsCode errorsCode, String message, List<String> errors) {
        this.httpCode = httpCode;
        this.errorsCode = errorsCode;
        this.message = message;
        this.errors = errors;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public ErrorsCode getErrorsCode() {
        return errorsCode;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}
