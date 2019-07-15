package com.cityexplore.ciplore.exceptions;

public class NotFoundExceptionResponse {
    private String NotFound;

    public NotFoundExceptionResponse(String notFound) {
        NotFound = notFound;
    }

    public String getNotFound() {
        return NotFound;
    }

    public void setNotFound(String notFound) {
        NotFound = notFound;
    }
}
