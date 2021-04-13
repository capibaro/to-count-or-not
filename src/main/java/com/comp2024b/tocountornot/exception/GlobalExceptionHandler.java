package com.comp2024b.tocountornot.exception;

import com.comp2024b.tocountornot.util.result.Result;
import com.comp2024b.tocountornot.util.result.Results;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public Result UnauthorizedExceptionHandler(UnauthorizedException ue) {
        return Results.getUnauthorizedResult(ue.getMessage());
    }

    @ExceptionHandler(value = ErrorException.class)
    @ResponseBody
    public Result ErrorException(ErrorException ee) {
        return Results.getErrorResult(ee.getMessage());
    }
}
