package com.comp2024b.tocountornot.util;

public enum Code {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private int code;

    Code(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}