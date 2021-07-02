package com.comp2024b.tocountornot.util;

public class ResultFactory {
    private static final String success = "success";
    private static final String created = "created";

    public static Result getSuccessResult() {
        return new Result().setCode(Code.SUCCESS).setMessage(success);
    }

    public static Result getSuccessResult(Object data) {
        return new Result().setCode(Code.SUCCESS).setMessage(success).setData(data);
    }

    public static Result getCreatedResult() {
        return new Result().setCode(Code.CREATED).setMessage(created);
    }

    public static Result getCreatedResult(Object data) {
        return new Result().setCode(Code.CREATED).setMessage(created).setData(data);
    }

    public static Result getBadRequestResult(String message) {
        return new Result().setCode(Code.BAD_REQUEST).setMessage(message);
    }

    public static Result getForbiddenResult(String message) {
        return new Result().setCode(Code.FORBIDDEN).setMessage(message);
    }

    public static Result getNotFoundResult(String message) {
        return new Result().setCode(Code.NOT_FOUND).setMessage(message);
    }

    public static Result getConflictResult(String message) {
        return new Result().setCode(Code.CONFLICT).setMessage(message);
    }

    public static Result getUnauthorizedResult(String message) {
        return new Result().setCode(Code.UNAUTHORIZED).setMessage(message);
    }

    public static Result getErrorResult(String message) {
        return new Result().setCode(Code.INTERNAL_SERVER_ERROR).setMessage(message);
    }
}
