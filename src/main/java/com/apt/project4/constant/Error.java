package com.apt.project4.constant;

public enum Error {
    OK(0, "OK"),
    UNEXPECTED(-1, "Unexpected"),
    VALIDATION(1, "Validation"),
    BUSINESS_LOGIC_ERROR(2, "Business logic");
    private final int code;
    private final String description;

    private Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
