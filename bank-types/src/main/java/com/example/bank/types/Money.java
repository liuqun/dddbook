package com.example.bank.types;

import com.example.bank.exception.InvalidCurrencyException;
import com.example.bank.exception.MoneyAmountNotNullException;
import com.example.bank.exception.UnexpectedCurrencyTypeException;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class Money implements Comparable<Money> {

    private final BigDecimal amount;

    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        if (null == amount){
            throw new MoneyAmountNotNullException("货币金额不能为空指针");
        }
        if (null == currency){
            throw new InvalidCurrencyException("货币币种不能为空指针");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public int compareTo(@Nonnull Money money) {
        if (currency.compareTo(money.getCurrency()) != 0) {
            // 货币币种不一致时直接比较金额无意义！
            throw new UnexpectedCurrencyTypeException();
        }
        return amount.compareTo(money.getAmount());
    }

    public Money subtract(@Nonnull Money money) throws UnexpectedCurrencyTypeException  {
        if (currency.compareTo(money.getCurrency()) != 0) {
            // 若货币币种不一致，则不能进行加减运算
            throw new UnexpectedCurrencyTypeException();
        }
        BigDecimal resultAmount = amount.subtract(money.getAmount());
        return new Money(resultAmount, currency);
    }

    public Money add(@Nonnull Money money) throws UnexpectedCurrencyTypeException {
        if (currency.compareTo(money.getCurrency()) != 0) {
            // 若货币币种不一致，则不能进行加减运算
            throw new UnexpectedCurrencyTypeException();
        }
        BigDecimal resultAmount = amount.add(money.getAmount());
        return new Money(resultAmount, currency);
    }
}
