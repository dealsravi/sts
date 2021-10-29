package org.somename.exceptions;

import org.somename.exceptions.base.BusinessException;

public class MaxStudentsReachedException extends BusinessException {
    public MaxStudentsReachedException() {
        super();
    }
    public MaxStudentsReachedException(String errorMessage)  {
        super(errorMessage);
    }

    public MaxStudentsReachedException(String errorMessage, Throwable T)  {
        super(errorMessage, T);
    }
}
