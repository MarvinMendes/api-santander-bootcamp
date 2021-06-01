package com.bootcamp.apisantanderbootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StockExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StockAlreadyRegisteredException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(StockAlreadyRegisteredException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(ex.getMessage()));
    }
}
