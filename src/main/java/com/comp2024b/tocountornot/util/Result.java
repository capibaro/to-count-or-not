package com.comp2024b.tocountornot.util;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result setCode(Code code) {
        this.code = code.getCode();
        return this;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}