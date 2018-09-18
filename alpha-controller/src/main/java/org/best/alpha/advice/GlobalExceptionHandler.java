package org.best.alpha.advice;

import org.best.alpha.enums.ResponseStatus;
import org.best.alpha.exception.NotFoundException;
import org.best.alpha.exception.ParameterException;
import org.best.alpha.response.AppResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AppResponse notSupportedMethodException() {
        return AppResponse.failure(ResponseStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(NotFoundException.class)
    public AppResponse noResourceException() {
        return AppResponse.failure(ResponseStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParameterException.class)
    public AppResponse parameterException() {
        return AppResponse.failure(ResponseStatus.FOUND);
    }

    @ExceptionHandler(Exception.class)
    public AppResponse unknownException() {
        return AppResponse.failure();
    }

}
