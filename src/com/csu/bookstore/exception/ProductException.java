package com.csu.bookstore.exception;

/**
 * 产品类相关的异常
 * @author sharp on 2017/12/4 0004 - 20:03
 */
public class ProductException extends Exception {
    public ProductException() {
        super();
    }
    
    public ProductException(String message) {
        super(message);
    }
    
    public ProductException(Throwable cause) {
        super(cause);
    }
    
    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
    
    protected ProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
