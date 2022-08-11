package com.example.bank.types;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

/**
 * Money 将金额及币种合并成一个整体
 *
 * 注意Money属于创建之后内部数据不可该变的的类型，即：
 * 1、不允许修改金额；2、不允许修改币种类型；
 */
public class Money implements Comparable<Money> {

    private final BigDecimal amount;

    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        if (null == amount){
            throw new IllegalArgumentException("货币金额不能为空指针");
        }
        if (null == currency){
            throw new IllegalArgumentException("货币币种不能为空指针");
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
        if (!Currency.equals(currency, money.getCurrency())) {
            // 货币币种不一致时直接比较金额无意义！
            throw new RuntimeException("货币币种不一致时直接比较金额无意义!");
        }
        return amount.compareTo(money.getAmount());
    }

    public Money subtract(@Nonnull Money money) {
        if (!Currency.equals(currency, money.getCurrency())) {
            // 若货币币种不一致，则不能进行加减运算
            throw new RuntimeException("货币币种不一致!");
        }
        BigDecimal resultAmount = amount.subtract(money.getAmount());
        return new Money(resultAmount, currency);
    }

    public Money add(@Nonnull Money money) {
        if (!Currency.equals(currency, money.getCurrency())) {
            // 若货币币种不一致，则不能进行加减运算
            throw new RuntimeException("货币币种不一致!");
        }
        BigDecimal resultAmount = amount.add(money.getAmount());
        return new Money(resultAmount, currency);
    }
}
