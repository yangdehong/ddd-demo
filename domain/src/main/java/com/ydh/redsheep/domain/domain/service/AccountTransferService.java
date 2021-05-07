package com.ydh.redsheep.domain.domain.service;

import com.ydh.redsheep.domain.domain.entity.AccountDO;
import com.ydh.redsheep.domain.exception.DailyLimitExceededException;
import com.ydh.redsheep.types.types.ExchangeRate;
import com.ydh.redsheep.types.types.Money;

public interface AccountTransferService {
    void transfer(AccountDO sourceAccountDO, AccountDO targetAccountDO, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException;
}
