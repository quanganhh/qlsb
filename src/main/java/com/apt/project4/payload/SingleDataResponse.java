package com.apt.project4.payload;

public class SingleDataResponse<T> extends BaseResponse {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleDataResponse(T t) {
        super("");
        this.data = t;
    }

    public SingleDataResponse(String message, T t) {
        super(message);
        this.data = t;
    }

    public SingleDataResponse(boolean isSuccess, String message) {
        super(isSuccess, message, null);
    }

    public SingleDataResponse(boolean isSuccess, String message, String errorCode, T t) {
        super(isSuccess, message, errorCode);
        this.data = t;
    }
}
