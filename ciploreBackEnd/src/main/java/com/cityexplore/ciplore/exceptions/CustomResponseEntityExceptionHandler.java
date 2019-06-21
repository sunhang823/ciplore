package com.cityexplore.ciplore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleIdentifierException(IdentifierException ex, WebRequest request) {
        IdentifierExceprionResponse identifierExceprionResponse = new IdentifierExceprionResponse(ex.getMessage());
        return new ResponseEntity<>(identifierExceprionResponse, HttpStatus.BAD_REQUEST);
    }
}
