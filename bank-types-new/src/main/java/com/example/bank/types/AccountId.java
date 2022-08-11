package com.example.bank.types;


public class AccountId {

    private final Long value;

    public AccountId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
