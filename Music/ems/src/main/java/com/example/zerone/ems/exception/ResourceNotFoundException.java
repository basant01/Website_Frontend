package com.example.zerone.ems.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}