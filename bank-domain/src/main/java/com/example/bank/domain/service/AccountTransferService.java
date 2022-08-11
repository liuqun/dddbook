package com.example.bank.domain.service;

import com.example.bank.domain.entity.Account;
import com.example.bank.ExchangeRate;
import com.example.bank.types.Money;

public interface AccountTransferService {
    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);
}
