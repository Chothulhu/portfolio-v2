package com.veljkovracarevic.portfolio.exceptions;

public class InfoNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public InfoNotFoundException(String message){
        super(message);
    }
}
