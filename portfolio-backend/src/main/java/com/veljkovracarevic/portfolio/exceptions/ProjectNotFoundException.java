package com.veljkovracarevic.portfolio.exceptions;

public class ProjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public ProjectNotFoundException(String message){
        super(message);
    }
}
