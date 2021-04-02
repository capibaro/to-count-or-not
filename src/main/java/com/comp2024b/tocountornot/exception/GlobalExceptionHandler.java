package com.comp2024b.tocountornot.exception;

import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.Results;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result ExceptionHandler(Exception e) {
        return Results.getFailResult(e.getMessage());
    }
}
