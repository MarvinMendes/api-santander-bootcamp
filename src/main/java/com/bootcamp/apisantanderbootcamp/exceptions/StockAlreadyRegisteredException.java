package com.bootcamp.apisantanderbootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class StockAlreadyRegisteredException extends Exception{

    public StockAlreadyRegisteredException(String message) {
        super(message);
    }
}
