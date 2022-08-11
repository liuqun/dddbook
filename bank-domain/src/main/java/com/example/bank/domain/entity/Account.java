package com.example.bank.domain.entity;

import com.example.bank.exception.DailyLimitExceededException;
import com.example.bank.exception.InsufficientFundsException;
import com.example.bank.exception.SinglePurchaseLimitExceededException;
import com.example.bank.types.*;

public class Account {

    private AccountId id;
    private AccountNumber accountNumber;
    private Money available;
    private Money dailyLimit;

    private Currency currency;

    public AccountId getId() {
        return id;
    }

    public void setId(AccountId id) {
        this.id = id;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Money getAvailable() {
        return available;
    }

    public void setAvailable(Money available) {
        this.available = available;
    }

    public Money getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(Money dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * withdraw(money) 从账户中支出一笔金额。
     *
     * @param money 支出金额，必须与账户主币种一致
     * @throws InsufficientFundsException 账户余额不足
     * @throws DailyLimitExceededException 当日累计消费超出限额
     * @throws SinglePurchaseLimitExceededException 单笔支出限额
     *
     * 需要额外检查:
     *
     *     1. 币种必须一致;
     *     2. 账户余额是否大于等于支出金额;
     *     3. 是否超出当日累计消费限额---此条依赖外部服务进行动态查询，故无法实现;
     *     4. 是否超出单笔支出限额;
     */
    public void withdraw(Money money) throws InsufficientFundsException, DailyLimitExceededException, SinglePurchaseLimitExceededException {
        available = available.subtract(money);
    }

    /**
     * deposit(money)
     * @param money 转入金额，必须与账户币种一致
     */
    public void deposit(Money money) {
       available = available.add(money);
    }
}
