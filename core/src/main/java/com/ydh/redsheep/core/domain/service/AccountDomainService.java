package com.ydh.redsheep.core.domain.service;

import com.ydh.redsheep.core.domain.entity.AccountDO;
import com.ydh.redsheep.core.domain.types.ExchangeRate;
import com.ydh.redsheep.core.domain.types.Money;
import com.ydh.redsheep.core.common.exception.DailyLimitExceededException;

public interface AccountDomainService {
    void transfer(AccountDO sourceAccountDO, AccountDO targetAccountDO, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException;
}
