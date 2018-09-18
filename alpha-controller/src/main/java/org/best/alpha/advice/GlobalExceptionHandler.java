package org.best.alpha.advice;

import org.best.alpha.response.AppResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(Exception.class)
    public AppResponse unknownException() {
        return AppResponse.failure();
    }

}
