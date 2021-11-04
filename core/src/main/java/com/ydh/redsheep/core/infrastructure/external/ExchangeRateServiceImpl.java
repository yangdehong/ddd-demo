package com.ydh.redsheep.core.infrastructure.external;

import com.ydh.redsheep.core.domain.types.Currency;
import com.ydh.redsheep.core.domain.types.ExchangeRate;
import com.ydh.redsheep.core.external.ExchangeRateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
//        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
//        }

    }
}
