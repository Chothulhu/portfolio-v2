package com.veljkovracarevic.portfolio.exceptions;

public class TechnologyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public TechnologyNotFoundException(String message){
        super(message);
    }

}
