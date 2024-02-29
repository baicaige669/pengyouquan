package com.feng.Exception;



//自定义异常
public class TokenException extends Exception {
    /**
     * 空参构造
     */
    public TokenException() {
    }

    public TokenException(String message) {
        super(message);
    }
}
