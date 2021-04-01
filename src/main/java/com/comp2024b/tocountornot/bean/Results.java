package com.comp2024b.tocountornot.bean;

public class Results {
    private static final String DEFAULT = "success";

    public static Result getSuccessResult() {
        return new Result().setCode(Code.SUCCESS).setMessage(DEFAULT);
    }

    public static Result getSuccessResult(Object data) {
        return new Result().setCode(Code.SUCCESS).setMessage(DEFAULT).setData(data);
    }

    public static Result getFailResult(String message) {
        return new Result().setCode(Code.FAIL).setMessage(message);
    }
}
