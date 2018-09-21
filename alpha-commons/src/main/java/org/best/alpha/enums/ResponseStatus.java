package org.best.alpha.enums;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {

    OK(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()),

    NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()),

    FOUND(HttpStatus.BAD_REQUEST.value(), "parameter given has exist!"),

    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE.value(),
            HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase()),

    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(),
            HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase()),

    DUPLICATION(HttpStatus.BAD_REQUEST.value(), "value of entity is duplicated"),

    PARAMETER(HttpStatus.BAD_REQUEST.value(), "parameter given is exception!");
    private Integer status;

    private String message;

    ResponseStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return this.message;
    }
}
