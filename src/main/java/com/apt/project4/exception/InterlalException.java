package com.apt.project4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InterlalException extends RuntimeException{
    public InterlalException(String message) {
        super(message);
    }

    public InterlalException(String message, Throwable cause) {
        super(message, cause);
    }
}
