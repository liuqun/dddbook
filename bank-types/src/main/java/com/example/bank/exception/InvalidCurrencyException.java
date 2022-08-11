package com.example.bank.exception;

public class InvalidCurrencyException extends IllegalArgumentException {
    /**
     * 带 message 参数的构造函数
     *
     * @param message 错误提示消息
     */
    public InvalidCurrencyException(String message) {
        super(message);
    }
}
