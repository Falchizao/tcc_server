package io.scarletgraph.api.handler.modelException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ErrorMessage extends RuntimeException {

    public ErrorMessage(String message){
        super(message);
    }
}