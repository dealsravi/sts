package org.somename.exceptions.base;

public class BusinessException extends BaseException {
    public BusinessException() {
        super();
    }
    public BusinessException(String errorMessage)  {
        super(errorMessage);
    }

    public BusinessException(String errorMessage, Throwable T)  {
        super(errorMessage, T);
    }
}
