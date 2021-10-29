package org.somename.exceptions;

import org.somename.exceptions.base.BusinessException;

public class MaxCoursesReachedException extends BusinessException {

    public MaxCoursesReachedException() {
        super();
    }
    public MaxCoursesReachedException(String errorMessage)  {
        super(errorMessage);
    }

    public MaxCoursesReachedException(String errorMessage, Throwable T)  {
        super(errorMessage, T);
    }

}
