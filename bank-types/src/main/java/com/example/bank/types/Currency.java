package com.example.bank.types;

import javax.annotation.Nonnull;

public class Currency implements Comparable<Currency> {

    private final String value;

    public Currency(@Nonnull String value) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(value)){
            throw new IllegalArgumentException("货币币种不允许设置为空字符串");
        }
        this.value = value;
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
        return compareTo(other) == 0;
    }

    @Override
    public boolean equals(@Nonnull Object obj) {
        if (obj.getClass() != Currency.class)
            return false;
        return this.equals((Currency) obj);
    }

    /**
     * 标准 compareTo() 方法
     * @param other 另一个货币币种对象
     * @return 货币币种相同返回0值, 不相同时返回非零整数
     */
    @Override
    public int compareTo(@Nonnull Currency other) {
        return org.apache.commons.lang3.StringUtils.compare(value, other.value);
    }

    @Override
    public String toString() {
        return "Currency{"
                + "value='" + value
                + "'}";
    }
}
