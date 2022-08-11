package com.example.bank.persistence;

import com.example.bank.domain.entity.Account;

public interface AccountBuilder {
    Account toAccount(AccountDO accountDO);

    AccountDO fromAccount(Account account);
}
