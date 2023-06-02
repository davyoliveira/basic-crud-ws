package com.softplan.crudapp.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ServiceResult implements Serializable {

    private static final long serialVersionUID = 8192759540460139543L;

    private int result;
    private String description;
    private String message;
    private HttpStatus httpStatus;
    private Object data;

    public ServiceResult () {
        this.result = ServiceResultEnum.ERROR.getCode();
        this.description = "";
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ServiceResult ( ServiceResultEnum serviceResultEnum ) {
        this.result = serviceResultEnum.getCode();
        this.description = serviceResultEnum.getDescription();
        this.httpStatus = serviceResultEnum.getHttpStatus();
    }

    public void set ( ServiceResultEnum serviceResultEnum ) {
        this.result = serviceResultEnum.getCode();
        this.description = serviceResultEnum.getDescription();
        this.httpStatus = serviceResultEnum.getHttpStatus();
    }

    public int getResult () {
        return result;
    }

    public void setResult ( int result ) {
        this.result = result;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    public HttpStatus getHttpStatus () {
        return httpStatus;
    }

    public void setHttpStatus ( HttpStatus httpStatus ) {
        this.httpStatus = httpStatus;
    }

    public Object getData () {
        return data;
    }

    public void setData ( Object object ) {
        this.data = object;
    }
}
