package io.scarletgraph.api.handler.modelException;

public class ObjectInsertionConflictException extends RuntimeException{
    private String message;

    public ObjectInsertionConflictException(String message){
        super(message);
    }
}