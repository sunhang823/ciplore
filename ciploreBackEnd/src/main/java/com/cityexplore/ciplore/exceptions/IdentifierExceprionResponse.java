package com.cityexplore.ciplore.exceptions;

public class IdentifierExceprionResponse {
    private String Identifier;

    public IdentifierExceprionResponse(String Identifier) {
        this.Identifier = Identifier;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }
}
