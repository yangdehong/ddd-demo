package com.ydh.redsheep.domain.domain.service.impl;

import com.ydh.redsheep.domain.domain.entity.AccountDO;
import com.ydh.redsheep.domain.domain.service.AccountTransferService;
import com.ydh.redsheep.domain.exception.DailyLimitExceededException;
import com.ydh.redsheep.types.types.ExchangeRate;
import com.ydh.redsheep.types.types.Money;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferServiceImpl implements AccountTransferService {
    @Override
    public void transfer(AccountDO sourceAccountDO, AccountDO targetAccountDO, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException {
        Money sourceMoney =  exchangeRate.exchageTo(targetMoney);
        sourceAccountDO.deposit(sourceMoney);
        targetAccountDO.withdraw(targetMoney);
    }
}
