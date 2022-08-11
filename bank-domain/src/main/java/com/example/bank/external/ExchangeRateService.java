package com.example.bank.external;

import com.example.bank.types.Currency;
import com.example.bank.ExchangeRate;

public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Currency source, Currency target);

}

