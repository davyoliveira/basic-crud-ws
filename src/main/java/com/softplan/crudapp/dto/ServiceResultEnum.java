package com.softplan.crudapp.dto;

import org.springframework.http.HttpStatus;

public enum ServiceResultEnum {

    SUCCESS ( 1 , "OK" , HttpStatus.OK ) , //
    ERROR ( - 1 , "Error" , HttpStatus.BAD_REQUEST );

    private int code;
    private String description;
    private HttpStatus httpStatus;

    ServiceResultEnum ( int code , String description , HttpStatus httpStatus ) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public int getCode () {
        return code;
    }

    public void setCode ( int code ) {
        this.code = code;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public HttpStatus getHttpStatus () {
        return httpStatus;
    }

    public void setHttpStatus ( HttpStatus httpStatus ) {
        this.httpStatus = httpStatus;
    }

}
