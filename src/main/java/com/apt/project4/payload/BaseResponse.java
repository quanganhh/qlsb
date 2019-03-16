package com.apt.project4.payload;

public class BaseResponse {

    private boolean isSuccess = true;
    private Object message = "success";
    private String errorCode = "0";
    private String additionalInfo = "";

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public BaseResponse() {
    }

    public BaseResponse(Object message) {
        this.isSuccess = true;
        this.message = message;
        this.errorCode = null;
    }

    public BaseResponse(boolean isSuccess, Object message, String errorCode) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.errorCode = errorCode;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

}
