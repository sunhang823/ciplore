package com.cityexplore.ciplore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdentifierException extends RuntimeException{

    public IdentifierException(String message) {
        super(message);
    }
}
