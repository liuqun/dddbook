package com.example.bank.application;

class Acknowledgement implements Result<Boolean> {
    private final Boolean data;

    public Acknowledgement(Boolean data) {
        this.data = data;
    }

    @Override
    public Boolean getData() {
        return data;
    }
}
