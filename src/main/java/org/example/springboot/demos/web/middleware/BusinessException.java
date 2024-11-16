package org.example.springboot.demos.web.middleware;

public class BusinessException extends RuntimeException {

    private int code;  // 错误码

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

