package com.csu.bookstore.exception;

/**
 * 自定义的异常
 * Created by sharp on 2017/12/1 0001 - 23:33
 */
public class UserException extends Exception {
    
    public UserException() {
        super();
    }
    
    public UserException(String message) {
        super(message);
    }
    
    public UserException(Throwable cause) {
        super(cause);
    }
    
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
