package com.example.bank.types;


public class AccountNumber {

    private final String value;

    public AccountNumber(String value) {
        if (value == null || "".equals(value)){
            throw new IllegalArgumentException("账号编码不能为空");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
