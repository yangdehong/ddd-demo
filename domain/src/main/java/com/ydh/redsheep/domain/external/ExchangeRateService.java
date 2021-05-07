package com.ydh.redsheep.domain.external;

import com.ydh.redsheep.types.types.Currency;
import com.ydh.redsheep.types.types.ExchangeRate;

public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Currency source, Currency target);

}

