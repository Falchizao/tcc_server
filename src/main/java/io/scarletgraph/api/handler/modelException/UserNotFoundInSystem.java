package io.scarletgraph.api.handler.modelException;

public class UserNotFoundInSystem extends RuntimeException{
    private String message;

    public UserNotFoundInSystem(String message){
        super(message);
    }
}