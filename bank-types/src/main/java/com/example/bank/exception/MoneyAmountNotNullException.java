package com.example.bank.exception;

public class MoneyAmountNotNullException extends IllegalArgumentException {
    public MoneyAmountNotNullException(String message) {
        super(message);
    }
}
