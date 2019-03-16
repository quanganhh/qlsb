package com.apt.project4.payload;

public class ErrorResponse extends BaseResponse{
    public ErrorResponse(Object message) {
        super(false, message, null);
    }

    public ErrorResponse(String message, String errorCode) {
        super(false, message, errorCode);
    }
}
