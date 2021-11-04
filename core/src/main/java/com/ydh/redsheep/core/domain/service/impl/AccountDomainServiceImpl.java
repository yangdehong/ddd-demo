package com.ydh.redsheep.core.domain.service.impl;

import com.ydh.redsheep.core.domain.entity.AccountDO;
import com.ydh.redsheep.core.domain.service.AccountDomainService;
import com.ydh.redsheep.core.domain.types.ExchangeRate;
import com.ydh.redsheep.core.domain.types.Money;
import com.ydh.redsheep.core.common.exception.DailyLimitExceededException;
import org.springframework.stereotype.Service;

@Service
public class AccountDomainServiceImpl implements AccountDomainService {
    @Override
    public void transfer(AccountDO sourceAccountDO, AccountDO targetAccountDO, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException {
        Money sourceMoney =  exchangeRate.exchageTo(targetMoney);
        sourceAccountDO.deposit(sourceMoney);
        targetAccountDO.withdraw(targetMoney);
    }
}
