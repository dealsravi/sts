package org.somename.exceptions;

import org.somename.exceptions.base.BusinessException;

public class CourseNotFoundException extends BusinessException {

    public CourseNotFoundException() {
        super();
    }
    public CourseNotFoundException(String errorMessage)  {
        super(errorMessage);
    }

    public CourseNotFoundException(String errorMessage, Throwable T)  {
        super(errorMessage, T);
    }

}
