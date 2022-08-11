package com.example.bank.external;

import com.example.bank.types.Currency;
import com.example.bank.ExchangeRate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * MockExchangeRateServiceImpl 假的汇率插叙
 */
@Service
public class MockExchangeRateServiceImpl implements ExchangeRateService{
    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        return new ExchangeRate(BigDecimal.ONE, source, target);
    }
}
