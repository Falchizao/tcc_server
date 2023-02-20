package io.scarletgraph.api.handler.modelException;

import java.util.Date;

public class ApiError {
    private Long timestap = new Date().getTime();
    private String message;
    private String url;
    private Integer status;

    public ApiError(Integer status, String message, String url){
        this.status = status;
        this.message = message;
        this.url = url;
    }

}