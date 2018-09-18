package org.best.alpha.exception;

import org.best.alpha.base.ApplicationException;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String message) {
        super(message);
    }
}
