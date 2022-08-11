package com.example.bank.domain.service.impl;

import com.example.bank.domain.entity.Account;
import com.example.bank.domain.service.AccountTransferService;
import com.example.bank.ExchangeRate;
import com.example.bank.types.Money;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferServiceImpl implements AccountTransferService {
    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) {
        Money local = exchangeRate.localMoneyFromForeignMoney(targetMoney);
        sourceAccount.withdraw(local);
        targetAccount.deposit(targetMoney);
    }
}
