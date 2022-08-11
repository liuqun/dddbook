package com.example.bank;

import com.example.bank.types.Currency;
import com.example.bank.types.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeRate {

    private final BigDecimal rate;// 500人民币 兑换 100美元则rate=5

    /// 本币币种 例如：人民币 = new Currency("CNY")
    private final Currency localCurrency;

    /// 外币币种 例如：美元 = new Currency("USD")
    private final Currency foreignCurrency;

    public ExchangeRate(BigDecimal rate, Currency localCurrency, Currency foreignCurrency) {
        this.rate = rate;
        this.localCurrency = localCurrency;
        this.foreignCurrency = foreignCurrency;
    }

    @Deprecated
    public Money exchangeTo(Money targetMoney) throws Exception {
        BigDecimal targetAmount = targetMoney.getAmount().multiply(rate);
        return new Money(targetAmount, foreignCurrency);
    }

    public Money localMoneyFromForeignMoney(Money dollar) {
        BigDecimal usd = dollar.getAmount();
        BigDecimal cny = usd.multiply(rate);
        return new Money(cny, localCurrency);
    }


    public Money foreignMoneyFromLocalMoney(Money yuan) {
        BigDecimal cny = yuan.getAmount();
        BigDecimal usd = cny.divide(rate, RoundingMode.FLOOR);
        return new Money(usd, foreignCurrency);
    }
}
