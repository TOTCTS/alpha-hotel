package org.best.alpha.exception;

import org.best.alpha.base.ApplicationException;

/**
 * @author: BG336672
 * @create: 2018-09-20 19:10
 * @description:
 **/
public class ConstraintViolationException extends ApplicationException{

    public ConstraintViolationException(String message) {
        super(message);
    }
}
