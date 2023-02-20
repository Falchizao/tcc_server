package io.scarletgraph.api.handler.modelException;

public class ObjectInvalidException extends RuntimeException{
    private String message;

    public ObjectInvalidException(String message){
        super(message);
    }
}