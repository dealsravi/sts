package org.somename.exceptions.base;

public class BaseException extends Throwable {

    public BaseException() {
        super();
    }
    public BaseException(String errorMessage)  {
        super(errorMessage);
    }

    public BaseException(String errorMessage, Throwable T)  {
        super(errorMessage, T);
    }
}
