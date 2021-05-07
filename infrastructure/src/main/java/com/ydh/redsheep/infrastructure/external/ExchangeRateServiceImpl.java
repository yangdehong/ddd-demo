package com.ydh.redsheep.infrastructure.external;

import com.ydh.redsheep.domain.external.ExchangeRateService;
import com.ydh.redsheep.types.types.Currency;
import com.ydh.redsheep.types.types.ExchangeRate;
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
