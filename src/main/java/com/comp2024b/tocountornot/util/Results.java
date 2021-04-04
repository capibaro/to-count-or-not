package com.comp2024b.tocountornot.util;

import com.comp2024b.tocountornot.util.Code;
import com.comp2024b.tocountornot.util.Result;

public class Results {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public static Result getSuccessResult() {
        return new Result().setCode(Code.SUCCESS).setMessage(SUCCESS);
    }

    public static Result getSuccessResult(Object data) {
        return new Result().setCode(Code.SUCCESS).setMessage(SUCCESS).setData(data);
    }

    public static Result getFailResult(String message) {
        return new Result().setCode(Code.FAIL).setMessage(message);
    }

    public static Result getUnauthorizedResult(String message) {
        return new Result().setCode(Code.UNAUTHORIZED).setMessage(message);
    }

    public static Result getNotFoundResult(String message) {
        return new Result().setCode(Code.NOT_FOUND).setMessage(message);
    }

    public static Result getErrorResult(String message) {
        return new Result().setCode(Code.INTERNAL_SERVER_ERROR).setMessage(message);
    }
}
