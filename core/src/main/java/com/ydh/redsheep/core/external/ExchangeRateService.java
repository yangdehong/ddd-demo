package com.ydh.redsheep.core.external;


import com.ydh.redsheep.core.domain.types.Currency;
import com.ydh.redsheep.core.domain.types.ExchangeRate;

public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Currency source, Currency target);

}

