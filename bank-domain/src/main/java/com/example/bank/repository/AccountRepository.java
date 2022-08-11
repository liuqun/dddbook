package com.example.bank.repository;

import com.example.bank.domain.entity.Account;
import com.example.bank.types.AccountId;
import com.example.bank.types.AccountNumber;
public interface AccountRepository {
    Account find(AccountId id);
    Account find(AccountNumber accountNumber);
    //Account find(UserId userId);
    Account save(Account account);
}
