package com.example.bank.types;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;


public class Currency {

    private final String value;

    public Currency(@Nonnull String value) {
        String valueTrimmed = value.trim();
        if (StringUtils.isEmpty(valueTrimmed)){
            throw new IllegalArgumentException("货币币种不允许设置为空字符串");
        }
        this.value = valueTrimmed;
    }

    public String getValue() {
        return value;
    }

    /**
     * 标准 equals() 方法
     * @param other 另一个货币币种对象
     * @return 货币币种相同返回true, 反之返回false
     */
    public boolean equals(@Nonnull Currency other) {
        return Currency.equals(this, other);
    }
    @Override
    public boolean equals(Object other) {
        return super.equals(other)
                || ( other.getClass() == Currency.class && Currency.equals(this, (Currency) other) );
    }

    /** 用法: Currency.equals(source, target) */
    public static boolean equals(Currency source, Currency target) {
        return StringUtils.equals(source.value, target.value);
    }

///**
// * 标准 compareTo() 方法
// * @param other 另一个货币币种对象
// * @return 货币币种相同返回0值, 不相同时返回非零整数
// */
//private int compareTo(@Nonnull Currency other) {
//    return StringUtils.compare(value, other.value);
//}

    @Override
    public String toString() {
        return "Currency{"
                + "value='" + value
                + "'}";
    }
}
