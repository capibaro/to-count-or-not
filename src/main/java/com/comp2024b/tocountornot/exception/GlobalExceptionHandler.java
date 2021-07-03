package com.comp2024b.tocountornot.exception;

import com.comp2024b.tocountornot.ToCountOrNotApplication;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ToCountOrNotApplication.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException mae) {
        return ResultFactory.getBadRequestResult(Objects.requireNonNull(mae.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Result ConstraintViolationExceptionHandler(ConstraintViolationException cve) {
        return ResultFactory.getBadRequestResult(cve.getCause().getMessage());
    }

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseBody
    public Result BadRequestExceptionHandler(BadRequestException bre) {
        return ResultFactory.getBadRequestResult(bre.getMessage());
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public Result UnauthorizedExceptionHandler(UnauthorizedException ue) {
        return ResultFactory.getUnauthorizedResult(ue.getMessage());
    }

    @ExceptionHandler(value = ForbiddenException.class)
    @ResponseBody
    public Result ForbiddenExceptionHandler(ForbiddenException fe) {
        return ResultFactory.getForbiddenResult(fe.getMessage());
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public Result NotFoundExceptionHandler(NotFoundException nfe) {
        return ResultFactory.getNotFoundResult(nfe.getMessage());
    }

    @ExceptionHandler(value = ConflictException.class)
    @ResponseBody
    public Result ConflictExceptionHandler(ConflictException ce) {
        return ResultFactory.getConflictResult(ce.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result ExceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultFactory.getErrorResult(e.getMessage());
    }
}
