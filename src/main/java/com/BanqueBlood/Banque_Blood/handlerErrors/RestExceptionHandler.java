package com.BanqueBlood.Banque_Blood.handlerErrors;

import com.BanqueBlood.Banque_Blood.exceptions.EntityNotFound;
import com.BanqueBlood.Banque_Blood.exceptions.InvalidEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<Error> handlerException(EntityNotFound exception, WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final Error error = Error.builder()
                .errorsCode(exception.getErrorsCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(error, notFound);
    }

    @ExceptionHandler(InvalidEntity.class)
    public ResponseEntity<Error> handlerException(InvalidEntity exception, WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final Error error = Error.builder()
                .errorsCode(exception.getErrorCode())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new  ResponseEntity<>(error, badRequest);
    }
}
